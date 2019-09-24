package ru.sb.MeetRoomBot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.sb.MeetRoomBot.bot.command.CommandRouter;
import ru.sb.MeetRoomBot.procassor.MsgProcessorRouter;

@Component
public class MeetRoomBot extends TelegramLongPollingBot {

    @Autowired
    private MsgProcessorRouter router;

    @Autowired
    private CommandRouter commandRouter;

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
//        SendMessage sendMessage = router.generate(message);
        SendMessage sendMessage = commandRouter.route(message);
        if(sendMessage!=null) {
            sendMsg(sendMessage);
        }
    }

    private void sendMsg(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "techbe_test_bot";
    }

    @Override
    public String getBotToken() {
        return "684556048:AAH0iy1iBA758MR6qbYCmk6wRzeu-jeEuEY";
    }
}

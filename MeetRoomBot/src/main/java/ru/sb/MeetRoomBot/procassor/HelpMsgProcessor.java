package ru.sb.MeetRoomBot.procassor;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.sb.MeetRoomBot.procassor.command.IncomingCommand;

@Component
public class HelpMsgProcessor implements MsgProcessor {
    @Override
    public IncomingCommand getCommand() {
        return IncomingCommand.INCOMING_HELP;
    }

    @Override
    public SendMessage generateMessage(Message message) {
        SendMessage sendMessage = getDef(message);

        String text = "Список доступных команд: \n - /help - получить список команд \n - /getMeetRoom - получить список переговорок \n - /setTimeZone [смещение времени]";
        sendMessage.setText(text);

        return sendMessage;
    }
}

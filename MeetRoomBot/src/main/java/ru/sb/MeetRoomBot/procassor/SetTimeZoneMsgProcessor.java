package ru.sb.MeetRoomBot.procassor;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.sb.MeetRoomBot.procassor.command.IncomingCommand;

@Component
public class SetTimeZoneMsgProcessor implements MsgProcessor {
    @Override
    public IncomingCommand getCommand() {
        return IncomingCommand.INCOMING_SET_TIME_ZONE;
    }

    @Override
    public SendMessage generateMessage(Message message) {
        SendMessage sendMessage = getDef(message);
        sendMessage.setText("Сорян, данная функция еще не реализована :(");

        return sendMessage;
    }
}

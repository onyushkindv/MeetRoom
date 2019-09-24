package ru.sb.MeetRoomBot.procassor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import ru.sb.MeetRoomBot.api.client.MeetRoomApiClient;
import ru.sb.MeetRoomBot.api.dto.UserDto;
import ru.sb.MeetRoomBot.procassor.command.IncomingCommand;

import java.util.List;


@Component
public class SetTimeZoneMsgProcessor implements MsgProcessor {


    @Autowired
    MeetRoomApiClient meetRoomApiClient;

    @Override
    public IncomingCommand getCommand() {
        return IncomingCommand.INCOMING_SET_TIME_ZONE;
    }

    @Override
    public SendMessage generateMessage(Message message) {
        SendMessage sendMessage = getDef(message);

        UserDto user = meetRoomApiClient.getUserByChannelId(message.getChatId());

        if(user!=null)
            sendMessage.setText("User - "+ user.getName() + "; phone - "+user.getPhoneNumber());
        else
            sendMessage.setText("User not found!!!");

        return sendMessage;
    }
}

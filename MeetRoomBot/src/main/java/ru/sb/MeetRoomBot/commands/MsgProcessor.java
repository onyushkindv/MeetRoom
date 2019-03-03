package ru.sb.MeetRoomBot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MsgProcessor {
    IncomingCommand getCommand();

    SendMessage generateMessage(Message message);

    default SendMessage getDef(Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
//        sendMessage.setReplyToMessageId(message.getMessageId());
//        sendMessage.setText(message.getText());
        return sendMessage;
    }
}

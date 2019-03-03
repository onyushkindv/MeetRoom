package ru.sb.MeetRoomBot.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.sb.MeetRoomBot.storage.UserStorage;

@Component
public class SetContactMsgProcessor implements MsgProcessor {
    private UserStorage userStorage;

    @Autowired
    public SetContactMsgProcessor(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public IncomingCommand getCommand() {
        return IncomingCommand.INCOMING_SET_CONTACT;
    }

    @Override
    public SendMessage generateMessage(Message message) {

        SendMessage sendMessage = getDef(message);
        sendMessage.setText("Спасибо" + (message.getContact().getFirstName()!=null?(" "+message.getContact().getFirstName()):"")+ ", ваш контакт подтвержден!");

        userStorage.resetStep(message.getChatId());

        return sendMessage;
    }
}

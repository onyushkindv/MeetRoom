package ru.sb.MeetRoomBot.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.sb.MeetRoomBot.storage.UserStorage;

import java.util.ArrayList;
import java.util.List;

@Component
public class HelloMsgProcessor implements MsgProcessor {

    private UserStorage userStorage;

    @Autowired
    public HelloMsgProcessor(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public IncomingCommand getCommand(){
        return IncomingCommand.INCOMING_START;
    }

    @Override
    public SendMessage generateMessage(Message message) {
        SendMessage sendMessage = getDef(message);
        sendMessage.setText("Привет! Я бот, который поможет тебе застолибить переговорку. Предоставьте свой номер телефона для авторизации.");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        replyKeyboardMarkup.setSelective(false);
        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        KeyboardButton keyboardButton = new KeyboardButton();

        keyboardButton.setText("Предоставить свой номер >").setRequestContact(true);
        keyboardFirstRow.add(keyboardButton);

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);

        userStorage.nextStep(message.getChatId(), getCommand());

        return sendMessage;
    }
}

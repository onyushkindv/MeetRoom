package ru.sb.MeetRoomBot.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartCommand extends Command {
    @Override
    String getName() {
        return "/start";
    }

    @Override
    public List<Command> doQuestion(Message message, SendMessage sendMessage) {

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


//        String text = "Список доступных команд: \n - /help - получить список команд \n - /getMeetRoom - получить список переговорок \n - /setTimeZone [смещение времени]";
//        sendMessage.setText(text);
        return super.doQuestion(message, sendMessage);
    }

    @Override
    public boolean doAnswer(Message message, SendMessage sendMessage) {

        Contact contact = message.getContact();
        if(contact!=null){
            sendMessage.setText("Здравствуйте - " + contact.getFirstName());
            return true;
        }

        return false;
    }

    @Override
    boolean answerable() {
        return true;
    }
}

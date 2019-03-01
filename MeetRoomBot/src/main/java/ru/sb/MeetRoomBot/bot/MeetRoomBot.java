package ru.sb.MeetRoomBot.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class MeetRoomBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        if (message != null && message.hasText()) {

            switch (message.getText()) {
                case "/start":
                    getPhoneNumber(message, "Привет! Я бот, который поможет тебе застолибить переговорку. Предоставьте свой номер телефона для авторизации.");
                    break;
//                case "":
                default:
                    sendTextMsg(message, "Привет! Я бот, который поможет тебе застолибить переговорку. Я не смог распознать команду. Что бы начать общение набери команду /start");
                    break;
            }
        }
        if(message!= null && message.hasContact()){
            sendTextMsg(message, "Спасибо" + (" "+message.getContact().getFirstName()==null?", ": " "+message.getContact().getFirstName()) + ", вы успешно прошли авторизацию.");
        }
    }


    private void getPhoneNumber(Message message, String text){
        SendMessage sendMessage = generateMsg(message, text);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

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

        sendMsg(sendMessage);
    }


    private void sendTextMsg(Message message, String text) {
        sendMsg(generateMsg(message, text));
    }

    private void sendMsg(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private SendMessage generateMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
//        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        return sendMessage;
    }

    public String getBotUsername() {
        return "techbe_test_bot";
    }

    @Override
    public String getBotToken() {
        return "684556048:AAH0iy1iBA758MR6qbYCmk6wRzeu-jeEuEY";
    }
}

package ru.sb.MeetRoomBot.bot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class NotFoundCommand extends Command {

    private final CommandStorage commandStorage;

    @Autowired
    public NotFoundCommand(CommandStorage commandStorage) {
        this.commandStorage = commandStorage;
    }

    @Override
    String getName() {
        return "/noteFound";
    }

    @Override
    public List<Command> doQuestion(Message message, SendMessage sendMessage) {
        String text = "Данная команда не распознана, список доступных команд: ";

        CommandGiven parentCommand = commandStorage.getUserCommand(message.getChatId());
        text += commandToString(parentCommand.getCommand().getCommands());
        sendMessage.setText(text);

        return super.doQuestion(message, sendMessage);
    }

    @Override
    boolean doAnswer(Message message, SendMessage sendMessage) {
        return false;
    }

    @Override
    boolean answerable() {
        return false;
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}

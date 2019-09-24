package ru.sb.MeetRoomBot.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    private List<Command> childCommands = new ArrayList<>();
    abstract String getName();

    public void addCommand(Command command) {
        childCommands.add(command);
    }

    public List<Command> getCommands() {
        if (childCommands.size() == 0)
            return null;
        return childCommands;
    }

    abstract boolean doAnswer(Message message, SendMessage sendMessage);

    abstract boolean answerable();

    public boolean isFinal(){
        return false;
    }

    protected String commandToString(List<Command> commands){
        String text = "";
        for(Command command: commands){
            text = text.concat(command.getName()+" ");
        }
        return text;
    }

//    public Command getCurrent(){
//        return this;
//    }

    public List<Command> doQuestion(Message message, SendMessage sendMessage){
//        childCommands.forEach(command -> command.parent=this);
        return getCommands();
    }
}

//@Component
//class StartCommand extends Command {
//
//    @Override
//    String getName() {
//        return "/start";
//    }
//
//    @Override
//    public List<Command> doQuestion(SendMessage sendMessage) {
//        String text = "this is start command";
//        sendMessage.setText(text);
//        return super.doQuestion(sendMessage);
//    }
//}

@Component
class MainCommand extends Command {
    @Override
    String getName() {
        return "/main";
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
    public List<Command> doQuestion(Message message, SendMessage sendMessage) {
        String text = "";
        sendMessage.setText(text);
        return super.doQuestion(message, sendMessage);
    }
}

@Component
class StopCommand extends Command {
    @Override
    String getName() {
        return "/stop";
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
    public List<Command> doQuestion(Message message, SendMessage sendMessage) {
        String text = "this is stop command";
        sendMessage.setText(text);
        return super.doQuestion(message, sendMessage);
    }
}

@Component
class ResetCommand extends Command {
    @Override
    String getName() {
        return "/reset";
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
    public List<Command> doQuestion(Message message, SendMessage sendMessage) {
        String text = "this is reset command";
        sendMessage.setText(text);
        return super.doQuestion(message, sendMessage);
    }
}


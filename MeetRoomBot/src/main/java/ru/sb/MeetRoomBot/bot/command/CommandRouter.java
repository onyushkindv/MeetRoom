package ru.sb.MeetRoomBot.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.annotation.PostConstruct;

@Component
public class CommandRouter {

    private final HelpCommand helpCommand;
    private final StartCommand startCommand;
    private final StopCommand stopCommand;
    private final ResetCommand resetCommand;
    private final NotFoundCommand notFoundCommand;

    private final CommandStorage commandStorage;

    public CommandRouter(NotFoundCommand notFoundCommand, HelpCommand helpCommand, StartCommand startCommand, StopCommand stopCommand, ResetCommand resetCommand, CommandStorage commandStorage) {
        this.notFoundCommand = notFoundCommand;
        this.helpCommand = helpCommand;
        this.startCommand = startCommand;
        this.stopCommand = stopCommand;
        this.resetCommand = resetCommand;
        this.commandStorage = commandStorage;

//        this.stopCommand.addCommand(this.startCommand);
//        this.resetCommand.addCommand(this.stopCommand);
//        this.stopCommand.addCommand(this.helpCommand);
//        this.resetCommand.addCommand(this.helpCommand);
    }

    @PostConstruct
    private void postConstruct() {
        this.helpCommand.addCommand(startCommand);
        this.helpCommand.addCommand(helpCommand);
        this.startCommand.addCommand(helpCommand);
        this.startCommand.addCommand(stopCommand);
        this.startCommand.addCommand(resetCommand);

        this.stopCommand.addCommand(this.startCommand);
        this.resetCommand.addCommand(this.stopCommand);
        this.stopCommand.addCommand(this.helpCommand);
        this.resetCommand.addCommand(this.helpCommand);
    }

    public SendMessage route(Message message) {

        CommandGiven currentCommand = commandStorage.getUserCommand(message.getChatId());

        if (currentCommand == null || currentCommand.getCommand() == null)
            currentCommand = new CommandGiven(helpCommand, false);

        System.out.println("current --- " + currentCommand.getCommand().getName() + "---");

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());

        Command nextCommand = null;

        if (currentCommand.getCommand().answerable() && !currentCommand.isAnswer()) {
            commandStorage.addUserCommand(message.getChatId(), new CommandGiven(currentCommand.getCommand(), currentCommand.getCommand().doAnswer(message, sendMessage)));
            return sendMessage;
        }

        for (Command com : currentCommand.getCommand().getCommands()) {
            System.out.println(com.getName() + "---");
            if (com.getName().equals(message.getText())) {
                com.doQuestion(message, sendMessage);
                if (com.isFinal())
                    nextCommand = currentCommand.getCommand();
                else
                    nextCommand = com;
                commandStorage.addUserCommand(message.getChatId(), new CommandGiven(nextCommand, currentCommand.getCommand().answerable()));
                break;
            }
        }

        if (nextCommand == null) {
            notFoundCommand.doQuestion(message, sendMessage);
        }

        return sendMessage;
    }


}

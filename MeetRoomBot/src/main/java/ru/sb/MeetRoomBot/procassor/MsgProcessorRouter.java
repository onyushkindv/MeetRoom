package ru.sb.MeetRoomBot.procassor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.sb.MeetRoomBot.procassor.command.IncomingCommand;
import ru.sb.MeetRoomBot.storage.UserStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MsgProcessorRouter {

    private Map<IncomingCommand, MsgProcessor> processors;
    private UserStorage userStorage;

    @Autowired
    public MsgProcessorRouter(List<MsgProcessor> processors, UserStorage userStorage) {
        this.userStorage = userStorage;
        this.processors = new HashMap<>();
        processors.forEach(p -> this.processors.put(p.getCommand(), p));
    }

    public SendMessage generate(Message message){

        String step = userStorage.getUserToStep().get(message.getChatId());

        //todo: Вынести в отдельный метод
        String command = message.getText();
        if(message!= null && message.hasContact()){
            command = IncomingCommand.INCOMING_SET_CONTACT.getValue();
        }

        if (message != null) {
            MsgProcessor processor = processors.get(IncomingCommand.valueOf(command, step==null?"":step));
            if (processor != null)
                return processor.generateMessage(message);
            else
                System.out.println("не нашел процессор в step:"+step);
        }

        return null;
    }
}

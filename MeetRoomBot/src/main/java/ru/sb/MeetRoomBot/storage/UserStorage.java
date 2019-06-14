package ru.sb.MeetRoomBot.storage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.sb.MeetRoomBot.procassor.command.IncomingCommand;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@Component
public class UserStorage {
    private Map<Long, String> userToStep = new ConcurrentHashMap<>();
    private Map<Long, Map<String, String>> userToParams = new ConcurrentHashMap<>();

    public void nextStep(Long chatId, IncomingCommand command) {
        String oldStep = userToStep.get(chatId);
        userToStep.put(chatId, oldStep != null && oldStep != "" ? (oldStep + "/" + command) : (command.toString()));
    }
    public void resetStep(Long chatId){
        userToStep.remove(chatId);
    }
}

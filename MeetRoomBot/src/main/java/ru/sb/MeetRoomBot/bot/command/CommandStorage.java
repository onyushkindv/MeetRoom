package ru.sb.MeetRoomBot.bot.command;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandStorage {
    private Map<Long, CommandGiven> store = new HashMap<>();


    public void addUserCommand(long id, CommandGiven command){
        store.put(id, command);
    }
    public CommandGiven getUserCommand(long id){
        return store.get(id);
    }
}

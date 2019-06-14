package ru.sb.MeetRoomBot.procassor.command;

import lombok.Getter;

@Getter
public enum IncomingCommand {
    INCOMING_START("/start", ""),

    INCOMING_SET_CONTACT("/setContact", INCOMING_START.toString()),
    INCOMING_HELP("/help", INCOMING_START.toString()),
    INCOMING_SET_TIME_ZONE("/setTimeZone", INCOMING_START.toString()),
    INCOMING_GET_MEET_ROOM("/getMeetRoom", INCOMING_START.toString());

    private String value;
    private String step;

    IncomingCommand(String value, String step) {
        this.value = value;
        this.step = step;
    }

    public static IncomingCommand valueOf(String value, String step){
        for(int i=0; i < IncomingCommand.values().length; i++){
            if(IncomingCommand.values()[i].getValue().equals(value) && IncomingCommand.values()[i].getStep().equals(step)){
                return IncomingCommand.values()[i];
            }
        }
        return null;
    }

}

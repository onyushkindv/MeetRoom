package ru.sb.MeetRoomBot.commands;

import lombok.Getter;

@Getter
public enum IncomingCommand {
    INCOMING_START("/start", ""),
    INCOMING_SET_CONTACT("/set_contact", INCOMING_START.toString());

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

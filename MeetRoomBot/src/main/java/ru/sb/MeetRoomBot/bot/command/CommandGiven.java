package ru.sb.MeetRoomBot.bot.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommandGiven {
    private Command command;
    private boolean isAnswer;
}

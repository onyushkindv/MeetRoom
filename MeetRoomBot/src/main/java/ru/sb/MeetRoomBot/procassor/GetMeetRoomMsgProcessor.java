package ru.sb.MeetRoomBot.procassor;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.sb.MeetRoomBot.procassor.command.IncomingCommand;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetMeetRoomMsgProcessor implements MsgProcessor {

    @Override
    public IncomingCommand getCommand() {
        return IncomingCommand.INCOMING_GET_MEET_ROOM;
    }

    @Override
    public SendMessage generateMessage(Message message) {

        SendMessage sendMessage = getDef(message);

        //----- генерируем список Переговорок
        List<String> listMeetRoom = new ArrayList<>();
        listMeetRoom.add("k122 (Саратов)");
        listMeetRoom.add("k122a (Саратов)");
        listMeetRoom.add("116 (Москва)");
        listMeetRoom.add("117 (Москва)");
        //-----------------------------------

        String text = "Список переговорок в которые возможна запсись:";
        for (String s : listMeetRoom) {
            text += "\n -- " + s;
        }

        sendMessage.setText(text);
        return sendMessage;
    }
}

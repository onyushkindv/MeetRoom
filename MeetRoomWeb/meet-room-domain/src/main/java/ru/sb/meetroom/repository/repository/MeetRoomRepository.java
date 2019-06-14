package ru.sb.meetroom.repository.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.MeetRoom;
import ru.sb.meetroom.repository.extend.ExtendMeetRoomRepository;

public interface MeetRoomRepository extends CrudRepository<MeetRoom, Long>, ExtendMeetRoomRepository {
}

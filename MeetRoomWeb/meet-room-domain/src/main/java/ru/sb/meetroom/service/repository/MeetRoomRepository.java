package ru.sb.meetroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.MeetRoom;
import ru.sb.meetroom.service.extend.ExtendMeetRoomRepository;

public interface MeetRoomRepository extends CrudRepository<MeetRoom, Long>, ExtendMeetRoomRepository {
}

package ru.sb.meetroom.repository.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.RoomStatus;
import ru.sb.meetroom.repository.extend.ExtendRoomStatusRepository;

public interface RoomStatusRepository extends CrudRepository<RoomStatus, Long>, ExtendRoomStatusRepository {
}

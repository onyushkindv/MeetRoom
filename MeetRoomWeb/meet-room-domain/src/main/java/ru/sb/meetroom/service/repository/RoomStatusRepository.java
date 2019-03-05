package ru.sb.meetroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.RoomStatus;
import ru.sb.meetroom.service.extend.ExtendRoomStatusRepository;

public interface RoomStatusRepository extends CrudRepository<RoomStatus, Long>, ExtendRoomStatusRepository {
}

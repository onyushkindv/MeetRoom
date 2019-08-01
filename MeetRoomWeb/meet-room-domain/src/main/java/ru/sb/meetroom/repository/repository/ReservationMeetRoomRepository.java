package ru.sb.meetroom.repository.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.ReservationMeetRoom;
import ru.sb.meetroom.repository.extend.ExtendReservationMeetRoomRepository;

public interface ReservationMeetRoomRepository extends CrudRepository<ReservationMeetRoom, Long>, ExtendReservationMeetRoomRepository {
}

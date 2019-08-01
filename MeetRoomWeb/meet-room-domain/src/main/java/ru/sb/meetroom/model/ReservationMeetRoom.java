package ru.sb.meetroom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ReservationMeetRoom {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVATION_MEET_ROOM_ID_SEQ")
    @SequenceGenerator(name = "RESERVATION_MEET_ROOM_ID_SEQ", sequenceName = "RESERVATION_MEET_ROOM_ID_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meet_room_id", nullable = false)
    private MeetRoom meetRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_reservation_id", nullable = false)
    private User userReservation;

    @Column(name = "dt_reservation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    private RoomStatus status;

    @Column(name = "dt_start", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;

    @Column(name = "dt_end", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
}

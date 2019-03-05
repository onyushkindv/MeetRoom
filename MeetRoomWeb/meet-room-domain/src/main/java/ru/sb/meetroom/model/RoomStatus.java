package ru.sb.meetroom.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RoomStatus {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_STATUS_ID_SEQ")
    @SequenceGenerator(name = "ROOM_STATUS_ID_SEQ", sequenceName = "ROOM_STATUS_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;
}

package ru.sb.meetroom.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MeetRoom {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEET_ROOM_ID_SEQ")
    @SequenceGenerator(name = "MEET_ROOM_ID_SEQ", sequenceName = "MEET_ROOM_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;
}

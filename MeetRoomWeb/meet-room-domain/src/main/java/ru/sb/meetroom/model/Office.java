package ru.sb.meetroom.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "offices")
public class Office {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OFFICE_ID_SEQ")
    @SequenceGenerator(name = "OFFICE_ID_SEQ", sequenceName = "OFFICE_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private Set<MeetRoom> meetRooms;
}

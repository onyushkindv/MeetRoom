package ru.sb.meetroom.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserRole {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLE_ID_SEQ")
    @SequenceGenerator(name = "USER_ROLE_ID_SEQ", sequenceName = "USER_ROLE_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;
}

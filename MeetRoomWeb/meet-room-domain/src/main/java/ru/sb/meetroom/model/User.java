package ru.sb.meetroom.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
public class User {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    @SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role_id", nullable = false)
    private UserRole userRole;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "bot_channel_id")
    private String botChannelId;

    @Column(name = "description", length = 1024)
    private String description;

}

package ru.sb.meetroom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String login;
    private String password;
    private UserRoleDto userRole;
    private String phoneNumber;
    private String botChannelId;
    private String description;

}

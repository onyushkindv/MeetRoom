package ru.sb.MeetRoomBot.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String login;
    private String password;
//    private UserRoleDto userRole;
    private String phoneNumber;
    private String botChannelId;
    private String description;
}

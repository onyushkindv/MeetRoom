package ru.sb.MeetRoomBot.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {
    private Long id;
    private String name;
    private String description;
}

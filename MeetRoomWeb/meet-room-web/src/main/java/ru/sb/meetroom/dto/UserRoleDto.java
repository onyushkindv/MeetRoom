package ru.sb.meetroom.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRoleDto {
    private Long id;
    private String name;
    private String description;
}

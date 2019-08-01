package ru.sb.meetroom.mapper;

import org.mapstruct.Mapper;
import ru.sb.meetroom.dto.UserRoleDto;
import ru.sb.meetroom.model.UserRole;

@Mapper
public interface UserRoleMapper {
    UserRole sourceToDestination(UserRoleDto dto);
    UserRoleDto destinationToSource(UserRole userRole);
}

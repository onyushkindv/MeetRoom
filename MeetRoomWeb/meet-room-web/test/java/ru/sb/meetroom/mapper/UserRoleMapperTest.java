package ru.sb.meetroom.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.sb.meetroom.dto.UserRoleDto;
import ru.sb.meetroom.model.UserRole;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRoleMapperTest {
    private UserRoleMapper userRoleMapper = Mappers.getMapper(UserRoleMapper.class);

    @Test
    public void sourceToDestination() {
        UserRoleDto dto = new UserRoleDto();
        dto.setId(1L);
        dto.setName("User");
        dto.setDescription("description");
        UserRole userRole = userRoleMapper.sourceToDestination(dto);
        assertEquals(userRole.getId(), dto.getId());
        assertEquals(userRole.getName(), dto.getName());
        assertEquals(userRole.getDescription(), dto.getDescription());
    }

    @Test
    public void destinationToSource() {
        UserRole userRole = new UserRole();
        userRole.setId(1L);
        userRole.setDescription("description");
        userRole.setName("User");
        UserRoleDto dto = userRoleMapper.destinationToSource(userRole);
        assertEquals(userRole.getId(), dto.getId());
        assertEquals(userRole.getName(), dto.getName());
        assertEquals(userRole.getDescription(), dto.getDescription());
    }
}

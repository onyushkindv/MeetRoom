package ru.sb.meetroom.mapper;

import javax.annotation.Generated;
import ru.sb.meetroom.dto.UserRoleDto;
import ru.sb.meetroom.model.UserRole;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-01T13:12:48+0400",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRole sourceToDestination(UserRoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserRole userRole = new UserRole();

        userRole.setId( dto.getId() );
        userRole.setName( dto.getName() );
        userRole.setDescription( dto.getDescription() );

        return userRole;
    }

    @Override
    public UserRoleDto destinationToSource(UserRole userRole) {
        if ( userRole == null ) {
            return null;
        }

        UserRoleDto userRoleDto = new UserRoleDto();

        userRoleDto.setId( userRole.getId() );
        userRoleDto.setName( userRole.getName() );
        userRoleDto.setDescription( userRole.getDescription() );

        return userRoleDto;
    }
}

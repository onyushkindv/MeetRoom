package ru.sb.meetroom.mapper;

import javax.annotation.Generated;
import ru.sb.meetroom.dto.UserDto;
import ru.sb.meetroom.dto.UserRoleDto;
import ru.sb.meetroom.model.User;
import ru.sb.meetroom.model.UserRole;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-01T13:12:48+0400",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User sourceToDestination(UserDto source) {
        if ( source == null ) {
            return null;
        }

        User user = new User();

        user.setId( source.getId() );
        user.setName( source.getName() );
        user.setLogin( source.getLogin() );
        user.setPassword( source.getPassword() );
        user.setUserRole( userRoleDtoToUserRole( source.getUserRole() ) );
        user.setPhoneNumber( source.getPhoneNumber() );
        user.setBotChannelId( source.getBotChannelId() );
        user.setDescription( source.getDescription() );

        return user;
    }

    @Override
    public UserDto destinationToSource(User destination) {
        if ( destination == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( destination.getId() );
        userDto.setName( destination.getName() );
        userDto.setLogin( destination.getLogin() );
        userDto.setPassword( destination.getPassword() );
        userDto.setPhoneNumber( destination.getPhoneNumber() );
        userDto.setBotChannelId( destination.getBotChannelId() );
        userDto.setDescription( destination.getDescription() );

        return userDto;
    }

    protected UserRole userRoleDtoToUserRole(UserRoleDto userRoleDto) {
        if ( userRoleDto == null ) {
            return null;
        }

        UserRole userRole = new UserRole();

        userRole.setId( userRoleDto.getId() );
        userRole.setName( userRoleDto.getName() );
        userRole.setDescription( userRoleDto.getDescription() );

        return userRole;
    }
}

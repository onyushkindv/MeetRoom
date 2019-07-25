package ru.sb.meetroom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sb.meetroom.dto.UserDto;
import ru.sb.meetroom.model.User;

@Mapper()
public interface UserMapper {

    @Mapping(target="userRole", ignore=true)
    User sourceToDestination(UserDto source);


    UserDto destinationToSource(User destination);
}

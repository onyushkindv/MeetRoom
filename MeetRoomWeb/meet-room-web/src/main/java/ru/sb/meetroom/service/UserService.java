package ru.sb.meetroom.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.meetroom.dto.UserDto;
import ru.sb.meetroom.mapper.UserMapper;
import ru.sb.meetroom.model.User;
import ru.sb.meetroom.model.UserRole;
import ru.sb.meetroom.repository.repository.UserRepository;
import ru.sb.meetroom.repository.repository.UserRoleRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public User getByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User> getAll(Integer skip, Integer take) {
        return userRepository.findAll(skip, take);
    }

    @Transactional
    public boolean createUser(UserDto userDto) {
        User user = mapper.sourceToDestination(userDto);
        UserRole userRole = userRoleRepository.findByNameContainingIgnoreCaseOrderById("User");
        if (userRole != null) {
            user.setUserRole(userRole);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}

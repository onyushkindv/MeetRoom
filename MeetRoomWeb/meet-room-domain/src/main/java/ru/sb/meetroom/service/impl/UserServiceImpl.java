package ru.sb.meetroom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.meetroom.model.User;
import ru.sb.meetroom.repository.repository.UserRepository;
import ru.sb.meetroom.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<User> getAll(Integer skip, Integer take) {
        return userRepository.findAll(skip, take);
    }
}

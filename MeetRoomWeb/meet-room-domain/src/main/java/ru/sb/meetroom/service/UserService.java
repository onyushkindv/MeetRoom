package ru.sb.meetroom.service;

import ru.sb.meetroom.model.User;

import java.util.List;


public interface UserService {
    User getByName(String name);
    List<User> getAll(Integer skip, Integer take);
}

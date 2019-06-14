package ru.sb.meetroom.repository.extend;

import ru.sb.meetroom.model.User;

import java.util.List;

public interface ExtendUserRepository {
    List<User> findAll(Integer skip, Integer take);
}

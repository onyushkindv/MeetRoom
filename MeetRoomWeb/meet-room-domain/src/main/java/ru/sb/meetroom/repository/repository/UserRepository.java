package ru.sb.meetroom.repository.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.User;
import ru.sb.meetroom.repository.extend.ExtendUserRepository;

public interface UserRepository extends CrudRepository<User, Long>, ExtendUserRepository {
    User getUserByName(String name);
}

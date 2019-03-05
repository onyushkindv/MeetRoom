package ru.sb.meetroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.User;
import ru.sb.meetroom.service.extend.ExtendUserRepository;

public interface UserRepository extends CrudRepository<User, Long>, ExtendUserRepository {
}

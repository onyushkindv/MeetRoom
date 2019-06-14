package ru.sb.meetroom.repository.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.UserRole;
import ru.sb.meetroom.repository.extend.ExtendUserRoleRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long>, ExtendUserRoleRepository {
}

package ru.sb.meetroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.UserRole;
import ru.sb.meetroom.service.extend.ExtendUserRoleRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long>, ExtendUserRoleRepository {
}

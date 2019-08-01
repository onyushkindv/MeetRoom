package ru.sb.meetroom.repository.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByNameContainingIgnoreCaseOrderById(String name);
}

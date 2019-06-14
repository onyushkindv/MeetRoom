package ru.sb.meetroom.repository.extend;

import ru.sb.meetroom.model.UserRole;

import java.util.List;

public interface ExtendUserRoleRepository {
    List<UserRole> getUserRoleByDescription(String description);

}

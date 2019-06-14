package ru.sb.meetroom.repository.extend.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sb.meetroom.model.UserRole;
import ru.sb.meetroom.repository.extend.ExtendUserRoleRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ExtendUserRoleRepositoryImpl implements ExtendUserRoleRepository {
    private final EntityManager entityManager;

    @Autowired
    public ExtendUserRoleRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserRole> getUserRoleByDescription(String description) {
        return null;
    }
}

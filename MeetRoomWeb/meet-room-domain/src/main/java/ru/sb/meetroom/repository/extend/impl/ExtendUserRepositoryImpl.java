package ru.sb.meetroom.repository.extend.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sb.meetroom.model.User;
import ru.sb.meetroom.repository.extend.ExtendUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class ExtendUserRepositoryImpl implements ExtendUserRepository {
    public EntityManager entityManager;

    @Autowired
    public ExtendUserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll(Integer skip, Integer take) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        TypedQuery<User> query = entityManager.createQuery(criteria);

        // добавляем пагинацию
        if (skip != null && take != null)
            query.setFirstResult(skip).setMaxResults(take);

        return query.getResultList();

    }
}

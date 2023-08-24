package erpSystem.repository.impl;

import erpSystem.base.repository.BaseRepository;
import erpSystem.base.repository.impl.BaseRepositoryImpl;
import erpSystem.entity.User;
import erpSystem.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public abstract class UserRepositoryImpl<T extends User> extends BaseRepositoryImpl<T, Long> implements UserRepository<T> {
    public UserRepositoryImpl(EntityManager em) {
        super(em);
    }
    @Override
    public boolean isUserExistsByUsername(String username) {
        TypedQuery<Long> query = em.createQuery("select count( u ) from " + getEntityClass().getSimpleName() + " u where u.username= :username", Long.class);
        query.setParameter("username", username);
        Long count = query.getSingleResult();
        return count > 0;
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        TypedQuery<Long> query = em.createQuery("select count( u ) from " + getEntityClass().getSimpleName() + " u where u.email= :email", Long.class);
        query.setParameter("email", email);
        Long count = query.getSingleResult();
        return count > 0;
    }

    @Override
    public T getUserByUsername(String username) {
        TypedQuery<T> query =
                em.createQuery("from " + getEntityClass().getSimpleName() + " u where u.username= :username "
                        , getEntityClass());

        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public Optional<T> getUserByEmail(String email) {
        TypedQuery<T> query =
                em.createQuery("from " + getEntityClass().getSimpleName() + " u where u.email= :email "
                        , getEntityClass());

        query.setParameter("email", email);
        try {
            T foundUser = query.getSingleResult();
            return Optional.ofNullable(foundUser);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    public String getLogInRoleByUsername(String username){
        Query query =
                em.createNativeQuery("SELECT u.dtype FROM users u WHERE u.username = :username ");
        query.setParameter("username", username);
        return query.getSingleResult().toString();

    }
}

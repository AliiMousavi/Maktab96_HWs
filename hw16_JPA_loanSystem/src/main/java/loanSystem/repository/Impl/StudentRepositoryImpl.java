package loanSystem.repository.Impl;

import loanSystem.base.repository.BaseRepositoryImpl;
import loanSystem.entity.Student;
import loanSystem.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student,Long> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public boolean isStudentExistsByUsername(String username) {
        TypedQuery<Long> query = em.createQuery("select count( u ) from " + getEntityClass().getSimpleName() + " u where u.username= :username", Long.class);
        query.setParameter("username", username);
        Long count = query.getSingleResult();
        return count > 0;
    }

    @Override
    public boolean isStudentExistsByEmail(String email) {
        TypedQuery<Long> query = em.createQuery("select count( u ) from " + getEntityClass().getSimpleName() + " u where u.email= :email", Long.class);
        query.setParameter("email", email);
        Long count = query.getSingleResult();
        return count > 0;
    }

    @Override
    public Student getStudentByUsername(String username) {
        TypedQuery<Student> query =
                em.createQuery("from " + getEntityClass().getSimpleName() + " u where u.username= :username "
                        , getEntityClass());

        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        TypedQuery<Student> query =
                em.createQuery("from " + getEntityClass().getSimpleName() + " u where u.email= :email "
                        , getEntityClass());

        query.setParameter("email", email);
        try {
            Student foundStudent = query.getSingleResult();
            return Optional.ofNullable(foundStudent);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}

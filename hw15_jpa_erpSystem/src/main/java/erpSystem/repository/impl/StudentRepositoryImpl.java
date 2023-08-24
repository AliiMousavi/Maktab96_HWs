package erpSystem.repository.impl;

import erpSystem.base.repository.impl.BaseRepositoryImpl;
import erpSystem.entity.Student;
import erpSystem.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class StudentRepositoryImpl extends UserRepositoryImpl<Student> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

}

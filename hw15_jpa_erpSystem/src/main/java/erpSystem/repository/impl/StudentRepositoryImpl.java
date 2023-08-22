package erpSystem.repository.impl;

import erpSystem.base.repository.impl.BaseRepositoryImpl;
import erpSystem.entity.Student;
import erpSystem.repository.StudentRepository;

import javax.persistence.EntityManager;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student, Long> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}

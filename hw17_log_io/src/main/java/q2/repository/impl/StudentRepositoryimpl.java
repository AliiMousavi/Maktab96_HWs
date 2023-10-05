package q2.repository.impl;

import q2.base.repository.BaseRepositoryImpl;
import q2.entity.Studentt;
import q2.repository.StudentRepository;

import javax.persistence.EntityManager;

public class StudentRepositoryimpl extends BaseRepositoryImpl<Studentt,Long> implements StudentRepository {
    public StudentRepositoryimpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Studentt> getEntityClass() {
        return Studentt.class;
    }
}

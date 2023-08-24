package erpSystem.repository.impl;

import erpSystem.base.repository.impl.BaseRepositoryImpl;
import erpSystem.entity.Professor;
import erpSystem.entity.Student;
import erpSystem.repository.ProfessorRepository;

import javax.persistence.EntityManager;
import java.util.Collection;

public class ProfessorRepositoryImpl extends UserRepositoryImpl<Professor> implements ProfessorRepository {
    public ProfessorRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Professor> getEntityClass() {
        return Professor.class;
    }
}

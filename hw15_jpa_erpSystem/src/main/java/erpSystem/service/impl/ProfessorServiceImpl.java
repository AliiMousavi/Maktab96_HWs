package erpSystem.service.impl;

import erpSystem.base.service.impl.BaseServiceImpl;
import erpSystem.entity.Professor;
import erpSystem.entity.Student;
import erpSystem.repository.ProfessorRepository;
import erpSystem.repository.StudentRepository;
import erpSystem.repository.UserRepository;
import erpSystem.service.ProfessorService;
import erpSystem.service.StudentService;

public class ProfessorServiceImpl extends UserServiceImpl<Professor>
        implements ProfessorService {
    public ProfessorServiceImpl(UserRepository<Professor> repository) {
        super(repository);
    }
}

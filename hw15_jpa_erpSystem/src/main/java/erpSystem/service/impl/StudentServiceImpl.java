package erpSystem.service.impl;

import erpSystem.base.service.impl.BaseServiceImpl;
import erpSystem.entity.Student;
import erpSystem.repository.StudentRepository;
import erpSystem.repository.UserRepository;
import erpSystem.service.StudentService;

import java.util.Optional;

public class StudentServiceImpl extends UserServiceImpl<Student>
        implements StudentService {
    public StudentServiceImpl(UserRepository<Student> repository) {
        super(repository);
    }
}

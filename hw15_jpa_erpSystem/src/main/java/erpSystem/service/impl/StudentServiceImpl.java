package erpSystem.service.impl;

import erpSystem.base.service.impl.BaseServiceImpl;
import erpSystem.entity.Student;
import erpSystem.repository.StudentRepository;
import erpSystem.service.StudentService;

public class StudentServiceImpl extends BaseServiceImpl<Student,Long, StudentRepository>
        implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }
}

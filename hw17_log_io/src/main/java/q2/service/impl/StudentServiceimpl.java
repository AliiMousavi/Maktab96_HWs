package q2.service.impl;

import q2.base.service.BaseServiceImpl;
import q2.entity.Studentt;
import q2.repository.StudentRepository;
import q2.service.StudentService;

public class StudentServiceimpl extends BaseServiceImpl<Studentt,Long, StudentRepository> implements StudentService {
    public StudentServiceimpl(StudentRepository repository) {
        super(repository);
    }
}

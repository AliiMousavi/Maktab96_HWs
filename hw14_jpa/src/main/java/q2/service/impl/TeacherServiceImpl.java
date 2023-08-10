package q2.service.impl;

import q2.entity.Teacher;
import q2.repository.TeacherRepository;
import q2.service.TeacherService;

import java.util.Collection;

public class TeacherServiceImpl implements TeacherService {

    protected final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }
    @Override
    public Teacher saveOrUpdate(Teacher teacher) {
        return repository.saveOrUpdate(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return repository.update(teacher);
    }

    @Override
    public Teacher load(Teacher teacher) {
        return repository.load(teacher);
    }

    @Override
    public Collection<Teacher> loadAll() {
        return repository.loadAll();
    }

    @Override
    public Teacher signUp(String firstName, String lastName, Long teacherId) {
        Teacher teacher = new Teacher(firstName , lastName , teacherId);
        repository.saveOrUpdate(teacher);
        return teacher;
    }

    @Override
    public boolean contains(Teacher teacher) {
        return repository.contains(teacher);
    }
}

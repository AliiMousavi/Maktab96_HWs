package q2.service.impl;

import q2.entity.Person;
import q2.entity.Student;
import q2.repository.StudentRepository;
import q2.service.StudentService;

import java.util.Collection;

public class StudentServiceImpl implements StudentService {

    protected final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }
    @Override
    public Student saveOrUpdate(Student student) {
        return repository.update(student);
    }

    @Override
    public Student update(Student student) {
        return repository.update(student);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student load(Long id) {
        return repository.load(id);
    }

    @Override
    public Collection<Student> loadAll() {
        return repository.loadAll();
    }

    @Override
    public Student signUp(String firstName, String lastName , long studentId) {
        Student student = new Student(firstName , lastName , studentId);
        repository.saveOrUpdate(student);
        return student;
    }

    @Override
    public boolean contains(Long id) {
        return repository.contains(id);
    }
}

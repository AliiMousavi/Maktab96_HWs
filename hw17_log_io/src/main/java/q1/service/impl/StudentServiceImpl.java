package q1.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.entity.Person;
import q1.entity.Student;
import q1.repository.StudentRepository;
import q1.service.StudentService;

import java.util.Collection;

public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    protected final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }
    @Override
    public Student saveOrUpdate(Student student) {
        logger.info("saveOrUpdate method started in service.");
        return repository.update(student);
    }

    @Override
    public Student update(Student student) {
        logger.info("update method started in service.");
        return repository.update(student);
    }

    @Override
    public void deleteById(Long id) {
        logger.info("deleteById method started in service.");
        repository.deleteById(id);
    }

    @Override
    public Student load(Long id) {
        logger.info("load method started in service.");
        return repository.load(id);
    }

    @Override
    public Collection<Student> loadAll() {
        logger.info("loadAll method started in service.");
        return repository.loadAll();
    }

    @Override
    public Student signUp(String firstName, String lastName , long studentId) {
        logger.info("signUp method started in service.");
        Student student = new Student(firstName , lastName , studentId);
        repository.saveOrUpdate(student);
        return student;
    }

    @Override
    public boolean contains(Long id) {
        logger.info("contains method started in service.");
        return repository.contains(id);
    }
}

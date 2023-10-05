package q1.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.entity.Teacher;
import q1.repository.TeacherRepository;
import q1.service.TeacherService;

import java.util.Collection;

public class TeacherServiceImpl implements TeacherService {
    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    protected final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }
    @Override
    public Teacher saveOrUpdate(Teacher teacher) {
        logger.info("saveOrUpdate method started in service.");
        return repository.saveOrUpdate(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        logger.info("update method started in service.");
        return repository.update(teacher);
    }

    @Override
    public void deleteById(Long id) {
        logger.info("deleteById method started in service.");
        repository.deleteById(id);
    }

    @Override
    public Teacher load(Long id) {
        logger.info("load method started in service.");
        return repository.load(id);
    }

    @Override
    public Collection<Teacher> loadAll() {
        logger.info("loadAll method started in service.");
        return repository.loadAll();
    }

    @Override
    public Teacher signUp(String firstName, String lastName, Long teacherId) {
        logger.info("signUp method started in service.");
        Teacher teacher = new Teacher(firstName , lastName , teacherId);
        repository.saveOrUpdate(teacher);
        return teacher;
    }

    @Override
    public boolean contains(Long id) {
        logger.info("contains method started in service.");
        return repository.contains(id);
    }
}

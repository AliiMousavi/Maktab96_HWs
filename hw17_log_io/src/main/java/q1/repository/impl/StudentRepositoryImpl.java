package q1.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.Main;
import q1.entity.Student;
import q1.repository.StudentRepository;

import javax.persistence.EntityManager;
import java.util.Collection;

public class StudentRepositoryImpl implements StudentRepository {
    private static final Logger logger = LoggerFactory.getLogger(StudentRepositoryImpl.class);

    protected EntityManager em;

    public StudentRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public Student saveOrUpdate(Student student) {
        logger.info("saveOrUpdate method started.");
        beginTransaction();
        Student student1 = saveWithoutTransaction(student);
        commitTransaction();
        em.clear();
        logger.info(student1.getFirstName() + " " + student1.getLastName() + " is savesd in database!",StudentRepositoryImpl.class.getSimpleName());

        return student1;
    }

    private Student saveWithoutTransaction(Student student) {
        logger.info("saveWithoutTransaction method started.");
        if (student.getId() == null)
            em.persist(student);
        else
            student = em.merge(student);
        logger.info(student.getFirstName() + " " + student.getLastName() + " is persist!",StudentRepositoryImpl.class.getSimpleName());
        return student;
    }

    @Override
    public Student update(Student student) {
        logger.info("update method started.");
        student = em.merge(student);
        logger.info(student.getFirstName() + " " + student.getLastName() + " is updated!",StudentRepositoryImpl.class.getSimpleName());
        return student;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("deleteById method started.");
        beginTransaction();
        em.remove(id);
        commitTransaction();
        logger.info("Student with id(" + id + ") is deleted!",StudentRepositoryImpl.class.getSimpleName());
    }

    @Override
    public Student load(Long id) {
        logger.info("load student method started.");
        logger.info("Student with id(" + id + ") is loaded!",StudentRepositoryImpl.class.getSimpleName());
        return em.find(Student.class, id);
    }

    @Override
    public Collection<Student> loadAll() {
        logger.info("loadAll student method started.");
        logger.info("all student are loaded!",StudentRepositoryImpl.class.getSimpleName());
        return em.createQuery("from " + Student.class.getSimpleName(), Student.class).getResultList();
    }

    @Override
    public boolean contains(Long id) {
        logger.info("contains Student method started.");
        return isStudentExist(em.find(Student.class, id));
    }

    @Override
    public void beginTransaction() {
        logger.info("beginTransaction method started.");
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
            logger.info("Transaction begin.");
        }
    }

    @Override
    public void commitTransaction() {
        logger.info("commitTransaction method started.");
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
            logger.info("Transaction commited.");
        }
    }

    @Override
    public void rollBack() {
        logger.info("rollBack method started.");
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            logger.info("Transaction roll backed!.");
        }

    }
    private boolean isStudentExist(Student student){
        logger.info("isStudentExist method started.");
        return student != null;
    }
}

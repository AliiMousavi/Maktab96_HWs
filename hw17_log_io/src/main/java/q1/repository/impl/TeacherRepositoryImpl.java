package q1.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.entity.Teacher;
import q1.repository.TeacherRepository;

import javax.persistence.EntityManager;
import java.util.Collection;

public class TeacherRepositoryImpl implements TeacherRepository {

    private static final Logger logger = LoggerFactory.getLogger(TeacherRepositoryImpl.class);

    protected EntityManager em;

    public TeacherRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Teacher saveOrUpdate(Teacher teacher) {
        logger.info("saveOrUpdate method started.");
        beginTransaction();
        Teacher teacher1 = saveWithoutTransaction(teacher);
        commitTransaction();
        em.clear();
        logger.info(teacher1.getFirstName() + " " + teacher1.getLastName() + " is savesd in database!",TeacherRepositoryImpl.class.getSimpleName());

        return teacher1;
    }

    private Teacher saveWithoutTransaction(Teacher teacher) {
        logger.info("saveWithoutTransaction method started.");
        if (teacher.getId() == null)
            em.persist(teacher);
        else
            teacher = em.merge(teacher);
        logger.info(teacher.getFirstName() + " " + teacher.getLastName() + " is persist!",TeacherRepositoryImpl.class.getSimpleName());
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        logger.info("update method started.");
        teacher = em.merge(teacher);
        logger.info(teacher.getFirstName() + " " + teacher.getLastName() + " is updated!",TeacherRepositoryImpl.class.getSimpleName());
        return teacher;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("deleteById method started.");
        beginTransaction();
        em.remove(id);
        commitTransaction();
        logger.info("teacher with id(" + id + ") is deleted!",TeacherRepositoryImpl.class.getSimpleName());
    }

    @Override
    public Teacher load(Long id) {
        logger.info("load Teacher method started.");
        logger.info("Teacher with id(" + id + ") is loaded!",TeacherRepositoryImpl.class.getSimpleName());
        return em.find(Teacher.class, id);
    }

    @Override
    public Collection<Teacher> loadAll() {
        logger.info("loadAll Teacher method started.");
        logger.info("all student are loaded!",TeacherRepositoryImpl.class.getSimpleName());
        return em.createQuery("from " + Teacher.class.getSimpleName(), Teacher.class).getResultList();
    }

    @Override
    public boolean contains(Long id) {
        logger.info("contains Teacher method started.");
        return isTeacherExist(em.find(Teacher.class, id));
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
    private boolean isTeacherExist(Teacher teacher){
        logger.info("isTeacherExist method started.");
        return teacher != null;
    }
}

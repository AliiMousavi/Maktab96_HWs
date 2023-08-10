package repository.impl;

import entity.Student;
import entity.Teacher;
import repository.TeacherRepository;

import javax.persistence.EntityManager;
import java.util.Collection;

public class TeacherRepositoryImpl implements TeacherRepository {

    protected EntityManager em;

    public TeacherRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Teacher saveOrUpdate(Teacher teacher) {
        beginTransaction();
        Teacher teacher1 = saveWithoutTransaction(teacher);
        commitTransaction();
        em.clear();
        return teacher1;
    }

    private Teacher saveWithoutTransaction(Teacher teacher) {
        if (teacher.getId() == null)
            em.persist(teacher);
        else
            teacher = em.merge(teacher);

        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        teacher = em.merge(teacher);
        return teacher;
    }

    @Override
    public Teacher load(Teacher teacher) {
        return em.find(Teacher.class, teacher);
    }

    @Override
    public Collection<Teacher> loadAll() {
        return em.createQuery("from " + Teacher.class.getSimpleName(), Teacher.class).getResultList();
    }

    @Override
    public boolean contains(Teacher teacher) {
        return isTeacherExist(em.find(Teacher.class, teacher));
    }

    @Override
    public void beginTransaction() {
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    @Override
    public void rollBack() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();

    }
    private boolean isTeacherExist(Teacher teacher){
        return teacher != null;
    }
}

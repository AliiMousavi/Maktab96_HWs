package q2.repository.impl;

import q2.entity.Teacher;
import q2.repository.TeacherRepository;

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
    public void deleteById(Long id) {
        beginTransaction();
        em.remove(id);
        commitTransaction();
    }

    @Override
    public Teacher load(Long id) {
        return em.find(Teacher.class, id);
    }

    @Override
    public Collection<Teacher> loadAll() {
        return em.createQuery("from " + Teacher.class.getSimpleName(), Teacher.class).getResultList();
    }

    @Override
    public boolean contains(Long id) {
        return isTeacherExist(em.find(Teacher.class, id));
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

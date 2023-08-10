package q2.repository.impl;

import q2.entity.Student;
import q2.repository.StudentRepository;

import javax.persistence.EntityManager;
import java.util.Collection;

public class StudentRepositoryImpl implements StudentRepository {

    protected EntityManager em;

    public StudentRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public Student saveOrUpdate(Student student) {
        beginTransaction();
        Student student1 = saveWithoutTransaction(student);
        commitTransaction();
        em.clear();
        return student1;
    }

    private Student saveWithoutTransaction(Student student) {
        if (student.getId() == null)
            em.persist(student);
        else
            student = em.merge(student);

        return student;
    }

    @Override
    public Student update(Student student) {
        student = em.merge(student);
        return student;
    }

    @Override
    public void deleteById(Long id) {
        beginTransaction();
        em.remove(id);
        commitTransaction();
    }

    @Override
    public Student load(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public Collection<Student> loadAll() {
        return em.createQuery("from " + Student.class.getSimpleName(), Student.class).getResultList();
    }

    @Override
    public boolean contains(Long id) {
        return isStudentExist(em.find(Student.class, id));
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
    private boolean isStudentExist(Student student){
        return student != null;
    }
}

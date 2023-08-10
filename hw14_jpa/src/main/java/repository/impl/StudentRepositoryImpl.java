package repository.impl;

import entity.Person;
import entity.Student;
import repository.StudentRepository;

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
    public Student load(Student student) {
        return em.find(Student.class, student);
    }

    @Override
    public Collection<Student> loadAll() {
        return em.createQuery("from " + Student.class.getSimpleName(), Student.class).getResultList();
    }

    @Override
    public boolean contains(Student student) {
        return isStudentExist(em.find(Student.class, student));
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

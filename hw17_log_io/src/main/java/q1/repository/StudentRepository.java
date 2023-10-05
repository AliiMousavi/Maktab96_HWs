package q1.repository;

import q1.entity.Student;

import java.util.Collection;

public interface StudentRepository {
    Student saveOrUpdate(Student student);
    Student update(Student student);
    void deleteById(Long id);
    Student load(Long id);
    Collection<Student> loadAll();
    boolean contains(Long id);

    void beginTransaction();

    void commitTransaction();

    void rollBack();
}
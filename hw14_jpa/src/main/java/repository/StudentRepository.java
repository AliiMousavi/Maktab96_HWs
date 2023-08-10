package repository;

import entity.Person;
import entity.Student;

import java.util.Collection;

public interface StudentRepository {
    Student saveOrUpdate(Student student);
    Student update(Student student);
    Student load(Student student);
    Collection<Student> loadAll();
    boolean contains(Student student);

    void beginTransaction();

    void commitTransaction();

    void rollBack();
}

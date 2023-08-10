package q2.service;

import q2.entity.Person;
import q2.entity.Student;

import java.util.Collection;

public interface StudentService {
    Student saveOrUpdate(Student student);
    Student update(Student student);
    void deleteById(Long id);
    Student load(Long id);
    Collection<Student> loadAll();

    Student signUp(String firstName,String lastName, long studentId);
    boolean contains(Long id);
}

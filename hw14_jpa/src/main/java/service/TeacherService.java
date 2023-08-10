package service;

import entity.Person;
import entity.Student;
import entity.Teacher;

import java.util.Collection;

public interface TeacherService {
    Teacher saveOrUpdate(Teacher teacher);
    Teacher update(Teacher teacher);
    Teacher load(Teacher teacher);
    Collection<Teacher> loadAll();

    Teacher signUp(String firstName,String lastName, Long teacherId);
    boolean contains(Teacher teacher);
}

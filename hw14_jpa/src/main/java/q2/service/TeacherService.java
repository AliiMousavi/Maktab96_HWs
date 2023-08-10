package q2.service;

import q2.entity.Teacher;

import java.util.Collection;

public interface TeacherService {
    Teacher saveOrUpdate(Teacher teacher);
    Teacher update(Teacher teacher);
    Teacher load(Teacher teacher);
    Collection<Teacher> loadAll();

    Teacher signUp(String firstName,String lastName, Long teacherId);
    boolean contains(Teacher teacher);
}

package repository;

import entity.Student;
import entity.Teacher;

import java.util.Collection;

public interface TeacherRepository {
    Teacher saveOrUpdate(Teacher teacher);
    Teacher update(Teacher teacher);
    Teacher load(Teacher teacher);
    Collection<Teacher> loadAll();
    boolean contains(Teacher teacher);

    void beginTransaction();

    void commitTransaction();

    void rollBack();
}

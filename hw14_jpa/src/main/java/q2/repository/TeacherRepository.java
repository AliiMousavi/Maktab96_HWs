package q2.repository;

import q2.entity.Teacher;

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

package q1.repository;

import q1.entity.Teacher;

import java.util.Collection;

public interface TeacherRepository {
    Teacher saveOrUpdate(Teacher teacher);
    Teacher update(Teacher teacher);
    void deleteById(Long id);
    Teacher load(Long id);
    Collection<Teacher> loadAll();
    boolean contains(Long id);

    void beginTransaction();

    void commitTransaction();

    void rollBack();
}

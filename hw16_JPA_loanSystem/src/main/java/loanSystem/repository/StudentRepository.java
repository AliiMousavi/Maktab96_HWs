package loanSystem.repository;

import loanSystem.base.repository.BaseRepository;
import loanSystem.entity.Student;

import java.util.Optional;

public interface StudentRepository extends BaseRepository<Student,Long> {
    boolean isStudentExistsByUsername(String username);

    boolean  isStudentExistsByEmail(String email);

    Student getStudentByUsername(String username);
    Optional<Student> getStudentByEmail(String email);
}

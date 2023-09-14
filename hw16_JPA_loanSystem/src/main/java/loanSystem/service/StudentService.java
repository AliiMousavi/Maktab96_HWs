package loanSystem.service;

import loanSystem.base.service.BaseService;
import loanSystem.entity.Student;

import java.util.Optional;

public interface StudentService extends BaseService<Student,Long> {
    boolean isStudentExistsByUsername(String username);

    boolean  isStudentExistsByEmail(String email);

    Student getStudentByUsername(String username);
    Optional<Student> getStudentByEmail(String email);
    boolean  isValidCredential (String... credential);

    boolean isValidEmailPattern(String email);
}

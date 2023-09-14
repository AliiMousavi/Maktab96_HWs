package loanSystem.service.Impl;

import loanSystem.base.service.BaseServiceImpl;
import loanSystem.entity.Student;
import loanSystem.repository.StudentRepository;
import loanSystem.service.StudentService;
import loanSystem.util.SecurityContext;

import java.util.Optional;
import java.util.regex.Pattern;

public class StudentServiceImpl extends BaseServiceImpl<Student,Long, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public boolean isStudentExistsByUsername(String username) {
        return repository.isStudentExistsByUsername(username);
    }

    @Override
    public boolean isStudentExistsByEmail(String email) {
        return repository.isStudentExistsByEmail(email);
    }

    @Override
    public Student getStudentByUsername(String username) {
        return repository.getStudentByUsername(username);
    }

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        return repository.getStudentByEmail(email);
    }

    @Override
    public boolean isValidCredential(String... credential) {
        Optional<Student> foundStudent;
        if (isValidEmailPattern(credential[1])){
            foundStudent=repository.getStudentByEmail(credential[1]);
            if (foundStudent.isPresent()) {
                setDataToSecurityContext(foundStudent.get());
                return credential[1].equals(foundStudent.get().getEmail())
                        && credential[2].equals(foundStudent.get().getPassword());
            }

        }else {
            foundStudent= Optional.ofNullable(repository.getStudentByUsername(credential[0]));
            if (foundStudent.isPresent()) {
                setDataToSecurityContext(foundStudent.get());
                return credential[0].equals(foundStudent.get().getUsername())
                        && credential[2].equals(foundStudent.get().getPassword());
            }
        }
        return false;
    }
    private void setDataToSecurityContext(Student student) {
        SecurityContext.id=student.getId();
        SecurityContext.username=student.getUsername();
        SecurityContext.email=student.getEmail();
        SecurityContext.firstName=student.getFirstName();
    }

    @Override
    public boolean isValidEmailPattern(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(emailRegex,email);
    }
}

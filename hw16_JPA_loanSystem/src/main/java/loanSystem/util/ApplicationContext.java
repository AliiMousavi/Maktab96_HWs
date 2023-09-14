package loanSystem.util;

import loanSystem.config.EntityManagerProvider;
import loanSystem.repository.Impl.NoPardakhtShodeGhestRepositoryImpl;
import loanSystem.repository.Impl.StudentRepositoryImpl;
import loanSystem.repository.NoPardakhtShodeGhestRepository;
import loanSystem.repository.StudentRepository;
import loanSystem.service.Impl.NoPardakhtShodeGhestServiceImpl;
import loanSystem.service.Impl.StudentServiceImpl;
import loanSystem.service.NoPardakhtShodeGhestService;
import loanSystem.service.StudentService;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em;
    private static final StudentRepository studentRepository;
    private static final StudentService studentService;
    private static final NoPardakhtShodeGhestRepository ghestRepository;
    private static final NoPardakhtShodeGhestService ghestService;

    static {
        em = EntityManagerProvider.getEntityManager();
        studentRepository = new StudentRepositoryImpl(em);
        studentService = new StudentServiceImpl(studentRepository);
        ghestRepository = new NoPardakhtShodeGhestRepositoryImpl(em);
        ghestService = new NoPardakhtShodeGhestServiceImpl(ghestRepository);
    }

    public static StudentService getStudentService (){
        return studentService;
    }
    public static NoPardakhtShodeGhestService getGhestService(){
        return ghestService;
    }
}

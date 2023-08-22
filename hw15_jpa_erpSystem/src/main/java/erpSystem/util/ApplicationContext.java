package erpSystem.util;

import erpSystem.config.EntityManagerProvider;
import erpSystem.repository.StudentRepository;
import erpSystem.repository.impl.StudentRepositoryImpl;
import erpSystem.service.StudentService;
import erpSystem.service.impl.StudentServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final StudentRepository studentRepository;
    private static final StudentService studentService;
    static final EntityManager em;

    static {
        em = EntityManagerProvider.getEntityManager();
        studentRepository = new StudentRepositoryImpl(em);
        studentService = new StudentServiceImpl(studentRepository);
    }

    public static StudentService getStudentService (){
        return studentService;
    }
}

package q1.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.entity.Student;
import q1.repository.PersonRepository;
import q1.repository.StudentRepository;
import q1.repository.TeacherRepository;
import q1.repository.impl.PersonRepositoryImpl;
import q1.repository.impl.StudentRepositoryImpl;
import q1.repository.impl.TeacherRepositoryImpl;
import q1.service.PersonService;
import q1.service.StudentService;
import q1.service.TeacherService;
import q1.service.impl.PersonServiceImpl;
import q1.service.impl.StudentServiceImpl;
import q1.service.impl.TeacherServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    static final EntityManagerFactory emf;
    static final EntityManager em;


    private static final PersonRepository personRepository;
    private static final PersonService personService;

    private static final StudentRepository studentRepository;
    private static final StudentService studentService;

    private static final TeacherRepository teacherRepository;
    private static final TeacherService teacherService;

    static {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();

        personRepository = new PersonRepositoryImpl(em);
        personService = new PersonServiceImpl(personRepository);

        studentRepository = new StudentRepositoryImpl(em);
        studentService = new StudentServiceImpl(studentRepository);

        teacherRepository = new TeacherRepositoryImpl(em);
        teacherService = new TeacherServiceImpl(teacherRepository);

    }

    public static PersonService getPersonService() {
        logger.info("getPersonService method class is run.");
        return personService;
    }

    public static StudentService getStudentService() {
        logger.info("getStudentService method class is run.");
        return studentService;
    }

    public static TeacherService getTeacherService() {
        logger.info("getTeacherService method class is run.");
        return teacherService;
    }
}

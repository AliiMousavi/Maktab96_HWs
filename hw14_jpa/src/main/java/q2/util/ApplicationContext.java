package q2.util;

import q2.entity.Student;
import q2.repository.PersonRepository;
import q2.repository.StudentRepository;
import q2.repository.TeacherRepository;
import q2.repository.impl.PersonRepositoryImpl;
import q2.repository.impl.StudentRepositoryImpl;
import q2.repository.impl.TeacherRepositoryImpl;
import q2.service.PersonService;
import q2.service.StudentService;
import q2.service.TeacherService;
import q2.service.impl.PersonServiceImpl;
import q2.service.impl.StudentServiceImpl;
import q2.service.impl.TeacherServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {

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
        return personService;
    }

    public static StudentService getStudentService() {
        return studentService;
    }

    public static TeacherService getTeacherService() {
        return teacherService;
    }
}

package erpSystem.util;

import erpSystem.config.EntityManagerProvider;
import erpSystem.entity.Course;
import erpSystem.entity.Student;
import erpSystem.entity.User;
import erpSystem.repository.*;
import erpSystem.repository.impl.*;
import erpSystem.service.*;
import erpSystem.service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em;

    private static final UserRepository<User> userRepository;
    private static final UserService<User> userService;

    private static final StudentRepository studentRepository;
    private static final StudentService studentService;

    private static final CourseRepository courseRepository;
    private static final CourseService courseService;

    private static final ProfessorRepository professorRepository;
    private static final ProfessorService professorService;

    private static final EducationDepartmentRepository educationDepartmentRepository;
    private static final EducationDepartmentService educationDepartmentService;



    static {
        em = EntityManagerProvider.getEntityManager();

        userRepository = new UserRepositoryImpl<>(em) {
            @Override
            public Class<User> getEntityClass() {
                return User.class;
            }
        };
        userService = new UserServiceImpl<>(userRepository);

        studentRepository = new StudentRepositoryImpl(em);
        studentService = new StudentServiceImpl(studentRepository);

        courseRepository = new CourseRepositoryImpl(em);
        courseService = new CourseServiceImpl(courseRepository);

        professorRepository = new ProfessorRepositoryImpl(em);
        professorService = new ProfessorServiceImpl(professorRepository);

        educationDepartmentRepository = new EducationDepartmentRepositoryImpl(em);
        educationDepartmentService = new EducationDepartmentServiceImpl(educationDepartmentRepository);

    }

    public static StudentService getStudentService (){
        return studentService;
    }

    public static ProfessorService getProfessorService(){
        return professorService;
    }

    public static EducationDepartmentService getEducationDepartmentService(){
        return educationDepartmentService;
    }

    public static UserService<User> getUserService(){
        return userService;
    }
    public static CourseService getCourseService(){
        return courseService;
    }
}

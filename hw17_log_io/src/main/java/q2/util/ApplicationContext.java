package q2.util;

import q2.config.EntityManagerProvider;
import q2.repository.CourseRepository;
import q2.repository.StudentCourseRatingRepository;
import q2.repository.StudentRepository;
import q2.repository.impl.CourseRepositoryimpl;
import q2.repository.impl.StudentCourseRatingRepositoryimpl;
import q2.repository.impl.StudentRepositoryimpl;
import q2.service.CourseService;
import q2.service.StudentCourseRatingService;
import q2.service.StudentService;
import q2.service.impl.CourseServiceimpl;
import q2.service.impl.StudentCourseRatingServiceimpl;
import q2.service.impl.StudentServiceimpl;


import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em;
    private static final StudentRepository studentRepository;
    private static final StudentService studentService;

    private static final CourseRepository courseRepository;
    private static final  CourseService courseService;
    private static final StudentCourseRatingRepository studentCourseRatingRepository;
    private static final StudentCourseRatingService studentCourseRatingService;

    static {
        em = EntityManagerProvider.getEntityManager();
        studentRepository = new StudentRepositoryimpl(em);
        studentService = new StudentServiceimpl(studentRepository);
        courseRepository = new CourseRepositoryimpl(em);
        courseService = new CourseServiceimpl(courseRepository);
        studentCourseRatingRepository = new StudentCourseRatingRepositoryimpl(em);
        studentCourseRatingService = new StudentCourseRatingServiceimpl(studentCourseRatingRepository);
    }

    public static CourseService getCourseService (){
        return courseService;
    }

    public static StudentService getStudentService (){
        return studentService;
    }

    public static StudentCourseRatingService getStudentCourseRatingService (){
        return studentCourseRatingService;
    }
}

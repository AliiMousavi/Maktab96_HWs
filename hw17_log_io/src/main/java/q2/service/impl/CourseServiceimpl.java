package q2.service.impl;

import q2.base.service.BaseServiceImpl;
import q2.entity.Course;
import q2.repository.CourseRepository;
import q2.service.CourseService;

public class CourseServiceimpl extends BaseServiceImpl<Course,Long, CourseRepository> implements CourseService {
    public CourseServiceimpl(CourseRepository repository) {
        super(repository);
    }
}

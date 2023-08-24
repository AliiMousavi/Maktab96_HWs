package erpSystem.service.impl;

import erpSystem.base.service.impl.BaseServiceImpl;
import erpSystem.entity.Course;
import erpSystem.repository.CourseRepository;
import erpSystem.service.CourseService;

public class CourseServiceImpl extends BaseServiceImpl<Course,Long, CourseRepository>
        implements CourseService {
    public CourseServiceImpl(CourseRepository repository){
        super(repository);
    }
}

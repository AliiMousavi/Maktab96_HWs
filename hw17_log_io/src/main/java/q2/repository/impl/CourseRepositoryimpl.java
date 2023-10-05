package q2.repository.impl;

import q2.base.repository.BaseRepositoryImpl;
import q2.entity.Course;
import q2.repository.CourseRepository;

import javax.persistence.EntityManager;

public class CourseRepositoryimpl extends BaseRepositoryImpl<Course,Long> implements CourseRepository {
    public CourseRepositoryimpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}

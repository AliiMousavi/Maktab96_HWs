package erpSystem.repository.impl;

import erpSystem.base.repository.impl.BaseRepositoryImpl;
import erpSystem.entity.Course;
import erpSystem.repository.CourseRepository;

import javax.persistence.EntityManager;

public class CourseRepositoryImpl extends BaseRepositoryImpl<Course,Long> implements CourseRepository {
    public CourseRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}

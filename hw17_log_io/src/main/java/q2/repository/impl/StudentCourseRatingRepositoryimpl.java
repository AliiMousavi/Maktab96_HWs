package q2.repository.impl;

import q2.base.repository.BaseRepositoryImpl;
import q2.entity.StudentCourseRating;
import q2.repository.StudentCourseRatingRepository;

import javax.persistence.EntityManager;

public class StudentCourseRatingRepositoryimpl extends BaseRepositoryImpl<StudentCourseRating,Long> implements StudentCourseRatingRepository {
    public StudentCourseRatingRepositoryimpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<StudentCourseRating> getEntityClass() {
        return StudentCourseRating.class;
    }
}

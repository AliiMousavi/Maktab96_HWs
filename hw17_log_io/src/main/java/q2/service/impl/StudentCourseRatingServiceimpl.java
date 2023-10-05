package q2.service.impl;

import q2.base.service.BaseServiceImpl;
import q2.entity.StudentCourseRating;
import q2.repository.StudentCourseRatingRepository;
import q2.service.StudentCourseRatingService;

public class StudentCourseRatingServiceimpl extends BaseServiceImpl<StudentCourseRating,Long, StudentCourseRatingRepository> implements StudentCourseRatingService {
    public StudentCourseRatingServiceimpl(StudentCourseRatingRepository repository) {
        super(repository);
    }
}

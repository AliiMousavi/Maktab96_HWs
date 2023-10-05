package q2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import q2.base.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "StudentCourseRating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseRating extends BaseEntity<Long> {
    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "rating")
    private double rating;

    @Column(name = "comment")
    private String comment;
}

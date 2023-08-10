package q2.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Teacher extends Person{
    @Column(name = "teacher_id")
//    @NotNull(message = "Teacher Id cannot be null")
//    @Size(min = 10, max = 10, message
//            = "Teacher Id must be 10 characters")
    Long teacherId;
    String degree;
    Masterdegree masterdegree;

    public Teacher(String firstName, String lastName, Long teacherId) {
        super(firstName, lastName);
        this.teacherId = teacherId;
    }
}

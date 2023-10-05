package q1.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student extends Person {
    @Column(name = "student_id")
//    @NotNull(message = "Student Id cannot be null")
//    @Size(min = 10, max = 10, message
//            = "Student Id must be 10 characters")
    Long studentId;

    @Column(name = "field_of_study")
    String fieldOfStudy;

    @Column(name = "entry_year")
    int entryYear;

    public Student(String firstName, String lastName, Long studentId) {
        super(firstName, lastName);
        this.studentId = studentId;
    }

    public Student(String firstName, String lastName, Date dateOfBirth, Long studentId, String fieldOfStudy, int entryYear) {
        super(firstName, lastName, dateOfBirth);
        this.studentId = studentId;
        this.fieldOfStudy = fieldOfStudy;
        this.entryYear = entryYear;
    }
}

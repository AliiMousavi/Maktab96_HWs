package erpSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student extends User{

    String studentId;

    float GpaOfPreviousSemester;

    int grade;

    @ManyToMany(mappedBy = "students" , cascade = CascadeType.PERSIST)
    List<Course> passedCourses = new ArrayList<>();



}

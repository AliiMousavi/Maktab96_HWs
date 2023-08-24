package erpSystem.entity;

import erpSystem.entity.enums.ProfessorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Professor extends Employee {

    @OneToMany(mappedBy = "professor")
    List<Course> Courses = new ArrayList<>();

    ProfessorType professorType;

}

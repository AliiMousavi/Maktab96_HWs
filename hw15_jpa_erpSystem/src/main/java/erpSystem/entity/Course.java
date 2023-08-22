package erpSystem.entity;

import erpSystem.base.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity<Long> {
    @ManyToMany(mappedBy = "passedCourses" , cascade = CascadeType.PERSIST)
    List<Student> students = new ArrayList<>();
}

package erpSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends User{

    @ManyToMany
    List<Course> courseList = new ArrayList<>();


}

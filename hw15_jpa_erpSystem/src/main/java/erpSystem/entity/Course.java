package erpSystem.entity;

import erpSystem.base.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity<Long> {

    String name;
    int unit;

    @ManyToOne
    Collage collage;

    @ManyToMany
    List<Student> students = new ArrayList<>();

    @ManyToOne
    Professor professor;
}

package erpSystem.entity;

import erpSystem.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity<Long> {
    @ManyToMany
    List<Student> students = new ArrayList<>();
}

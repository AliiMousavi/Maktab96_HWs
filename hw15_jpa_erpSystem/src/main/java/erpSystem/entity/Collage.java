package erpSystem.entity;

import erpSystem.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Collage extends BaseEntity<Long> {
    String correntYear;
    String correntSemester;

    @OneToMany(mappedBy = "collage")
    List<Course> CollageCourseList = new ArrayList<>();
}

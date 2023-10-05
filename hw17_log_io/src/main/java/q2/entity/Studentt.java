package q2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import q2.base.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Studentt")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studentt extends BaseEntity<Long> {

    @Column(name = "student_name")
    private String studentName;

}

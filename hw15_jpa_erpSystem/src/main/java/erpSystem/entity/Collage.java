package erpSystem.entity;

import erpSystem.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class Collage extends BaseEntity<Long> {
    String AcademicYear;
    String AcademicSemester;
}

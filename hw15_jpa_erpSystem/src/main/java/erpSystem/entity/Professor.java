package erpSystem.entity;

import erpSystem.entity.enums.ProfessorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Professor extends Employee{

    ProfessorType professorType;
}

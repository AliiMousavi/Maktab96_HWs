package erpSystem.entity;

import erpSystem.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity<Long> {

    String firstName;
    String lastName;
    String username;
    String password;
    String email;
    String mobileNumber;
}

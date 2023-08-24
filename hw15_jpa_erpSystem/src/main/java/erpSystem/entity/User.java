package erpSystem.entity;

import erpSystem.base.entity.BaseEntity;
import erpSystem.entity.enums.LogInRole;
import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Users")
public class User extends BaseEntity<Long> {

    String firstName;
    String lastName;
    @Column(unique = true)
    String username;
    String password;
    String email;
    @Column(length = 11)
    String mobileNumber;
}

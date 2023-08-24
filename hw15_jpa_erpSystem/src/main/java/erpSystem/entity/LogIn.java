package erpSystem.entity;

import erpSystem.base.entity.BaseEntity;
import erpSystem.entity.enums.LogInRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogIn extends BaseEntity<Long> {
    LogInRole logInRole;
    String username;
    String email;
    String password;
}

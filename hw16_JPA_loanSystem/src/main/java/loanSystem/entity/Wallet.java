package loanSystem.entity;

import loanSystem.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wallet extends BaseEntity<Long> {
    String CardNumber;
    String cvv2;
    Date CardExpirationDate;

}

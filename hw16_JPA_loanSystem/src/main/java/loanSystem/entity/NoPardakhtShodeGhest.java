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
public class NoPardakhtShodeGhest extends BaseEntity<Long> {

    int number;
    Date sarResidDate;
    int amount;

    @Override
    public String toString() {
        return "number=" + number +
                ", sarResidDate=" + sarResidDate +
                ", amount=" + amount +
                '\n';
    }
}

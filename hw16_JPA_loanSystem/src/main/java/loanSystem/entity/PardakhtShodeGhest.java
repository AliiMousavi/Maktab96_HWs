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
public class PardakhtShodeGhest extends BaseEntity<Long> {

    int number;
    Date pardakhtDate;

    @Override
    public String toString() {
        return  number + "_ " +
                pardakhtDate +
                '\n';
    }
}

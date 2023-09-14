package loanSystem.entity;

import loanSystem.base.entity.BaseEntity;
import loanSystem.entity.enums.LoanType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan extends BaseEntity<Long> {
    LoanType loanType;
    int amount;
    @OneToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH})
    List<NoPardakhtShodeGhest> noPardakhtShodeGhests;
    @OneToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH})
    List<PardakhtShodeGhest> PardakhtShodeGhests;

}

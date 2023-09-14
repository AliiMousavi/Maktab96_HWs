package loanSystem.entity;

import loanSystem.base.entity.BaseEntity;
import loanSystem.entity.enums.College;
import loanSystem.entity.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity<Long> {

    String firstName;
    String lastName;
    String fatherName;
    String motherName;
    @Column(unique = true)
    String NationalCode;
    String NationalId;
    Date dateOfBirth;
    @Column(unique = true)
    String studentId;
    String collageName;
    College collegeType;
    int entryYear;
    Degree degree;
    String city;
    boolean isGraduated;
    @Column(unique = true)
    String username;
    String password;
    String email;
    @Column(length = 11)
    String mobileNumber;
    @OneToOne(cascade = CascadeType.PERSIST)
    Wallet wallet;
    @OneToOne(cascade = CascadeType.PERSIST)
    Loan loan;
//    @OneToOne(cascade = CascadeType.PERSIST)
//    Student wife;
//    int maskanShomareQarardad;
}

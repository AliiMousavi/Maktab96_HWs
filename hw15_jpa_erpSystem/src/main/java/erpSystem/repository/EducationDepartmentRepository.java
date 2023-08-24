package erpSystem.repository;

import erpSystem.base.repository.BaseRepository;
import erpSystem.entity.EducationDepartment;

public interface EducationDepartmentRepository extends UserRepository<EducationDepartment> {

    EducationDepartment getEmployeeBYEmployeeId(String EmployeeId);
}

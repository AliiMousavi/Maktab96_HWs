package erpSystem.service.impl;

import erpSystem.base.service.impl.BaseServiceImpl;
import erpSystem.entity.EducationDepartment;
import erpSystem.repository.EducationDepartmentRepository;
import erpSystem.repository.UserRepository;
import erpSystem.service.EducationDepartmentService;

public class EducationDepartmentServiceImpl extends UserServiceImpl<EducationDepartment>
        implements EducationDepartmentService {
    public EducationDepartmentServiceImpl(UserRepository<EducationDepartment> repository) {
        super(repository);
    }
}

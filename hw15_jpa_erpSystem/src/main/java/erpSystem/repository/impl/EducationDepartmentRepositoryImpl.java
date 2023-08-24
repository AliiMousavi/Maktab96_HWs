package erpSystem.repository.impl;

import erpSystem.base.repository.impl.BaseRepositoryImpl;
import erpSystem.entity.EducationDepartment;
import erpSystem.repository.EducationDepartmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EducationDepartmentRepositoryImpl extends UserRepositoryImpl<EducationDepartment>
        implements EducationDepartmentRepository {
    public EducationDepartmentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<EducationDepartment> getEntityClass() {
        return EducationDepartment.class;
    }

    @Override
    public EducationDepartment getEmployeeBYEmployeeId(String EmployeeId) {
        TypedQuery<EducationDepartment> query =
                em.createQuery("from " + getEntityClass().getSimpleName() + " u where u.EmployeeId= :EmployeeId "
                        , getEntityClass());

        query.setParameter("EmployeeId", EmployeeId);
        return query.getSingleResult();
    }
}

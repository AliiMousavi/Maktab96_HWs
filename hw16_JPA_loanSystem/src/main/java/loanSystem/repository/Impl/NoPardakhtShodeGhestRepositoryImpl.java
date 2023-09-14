package loanSystem.repository.Impl;

import loanSystem.base.repository.BaseRepositoryImpl;
import loanSystem.entity.NoPardakhtShodeGhest;
import loanSystem.entity.Student;
import loanSystem.repository.NoPardakhtShodeGhestRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class NoPardakhtShodeGhestRepositoryImpl extends BaseRepositoryImpl<NoPardakhtShodeGhest,Long> implements NoPardakhtShodeGhestRepository {
    public NoPardakhtShodeGhestRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<NoPardakhtShodeGhest> getEntityClass() {
        return NoPardakhtShodeGhest.class;
    }

    @Override
    public NoPardakhtShodeGhest getAndDeleteFirstNoPardakhtShodeGhest() {
        TypedQuery<NoPardakhtShodeGhest> query = em.createQuery("FROM NoPardakhtShodeGhest ORDER BY number ASC", NoPardakhtShodeGhest.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    @Override
    public void deleteGhestByNumber(int number) {
        Query query = em.createQuery("DELETE FROM NoPardakhtShodeGhest WHERE number = :number");
        query.setParameter("number", number);
    }
}

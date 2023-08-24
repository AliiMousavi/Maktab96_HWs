package erpSystem.base.repository.impl;

import erpSystem.base.entity.BaseEntity;
import erpSystem.base.repository.BaseRepository;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public abstract class BaseRepositoryImpl
        <T extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<T, ID> {
    protected EntityManager em;

    @Override
    public T saveOrUpdate(T entity) {
        entity = saveWithoutTransaction(entity);
        return entity;
    }

    public T saveWithoutTransaction(T entity) {
        if (entity.getId() == null)
            em.persist(entity);
        else
            entity = em.merge(entity);

        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(em.find(getEntityClass(),id));
    }

    @Override
    public void deleteById(ID id) {
        em.remove(id);
    }

    @Override
    public Collection<T> findAll() {
        return em.createQuery("from "+ getEntityClass().getSimpleName(),getEntityClass()).getResultList();
    }

    @Override
    public long getCount() {
        return
                em.createQuery("select count( e ) from "+getEntityClass().getSimpleName()+" e ",Long.class)
                        .getSingleResult();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        List<T> savedEntity=new ArrayList<>();
        entityCollection.forEach(e->savedEntity.add(saveWithoutTransaction(e)));
        return savedEntity;
    }

    @Override
    public void beginTransaction() {
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();

    }

    @Override
    public void commitTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    @Override
    public void rollBack() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();
    }

    public abstract Class<T> getEntityClass();
}

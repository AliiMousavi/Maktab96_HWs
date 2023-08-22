package erpSystem.base.service.impl;

import erpSystem.base.entity.BaseEntity;
import erpSystem.base.repository.BaseRepository;
import erpSystem.base.service.BaseService;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {
    protected final R repository;


    @Override
    public T saveOrUpdate(T entity) {
        beginTransaction();
        repository.saveOrUpdate(entity);
        commitTransaction();
        return entity;
    }


    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(ID id) {
        beginTransaction();
        repository.deleteById(id);
        commitTransaction();
    }

    @Override
    public Collection<T> findAll() {
        return repository.findAll();
    }

    @Override
    public long getCount() {
        return repository.getCount();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        beginTransaction();
        List<T> ts = (List<T>) repository.saveAll(entityCollection);
        commitTransaction();
        return ts;

    }

    @Override
    public void beginTransaction() {
        repository.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        repository.commitTransaction();
    }

    @Override
    public void rollBack() {
        repository.rollBack();
    }
}

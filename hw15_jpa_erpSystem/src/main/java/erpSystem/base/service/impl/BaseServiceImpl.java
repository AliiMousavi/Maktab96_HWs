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
        try {
            repository.saveOrUpdate(entity);
            commitTransaction();
        }catch (Exception e){
            rollBack();
        }
        return entity;
    }


    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(ID id) {
        beginTransaction();
        try {
            repository.deleteById(id);
            commitTransaction();
        }catch (Exception e){
            rollBack();
        }

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
        try {
            List<T> ts = (List<T>) repository.saveAll(entityCollection);
            commitTransaction();
            return ts;
        }catch (Exception e){
            rollBack();
        }
        return entityCollection;
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

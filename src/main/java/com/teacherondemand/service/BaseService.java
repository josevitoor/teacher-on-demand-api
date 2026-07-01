package com.teacherondemand.service;

import com.teacherondemand.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseService<T, ID> {

    protected abstract BaseRepository<T, ID> repository();

    public T save(T entity) {
        return repository().save(entity);
    }

    public List<T> getAll() {
        return repository().findAll();
    }

    public List<T> getAll(Sort sort) {
        return repository().findAll(sort);
    }

    public Page<T> getAll(Pageable pageable) {
        return repository().findAll(pageable);
    }

    public T getById(ID id) {
        return repository()
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Registro não encontrado"));
    }

    public boolean exists(ID id) {
        return repository().existsById(id);
    }

    public long count() {
        return repository().count();
    }

    public void deleteById(ID id) {
        T entity = getById(id);
        repository().delete(entity);
    }

    public void delete(T entity) {
        repository().delete(entity);
    }
}
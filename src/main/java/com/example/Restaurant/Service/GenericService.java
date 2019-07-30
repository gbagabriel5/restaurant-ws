package com.example.Restaurant.Service;

import com.example.Restaurant.domain.BaseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface GenericService<T extends BaseEntity<I>, I> {

    T saveOrUpdate(T entity);

    List<T> getAll();

    Page<T> getAllPaginated(Pageable pageable);

    Page<T> getAllPaginated(Example<T> example, Pageable pageable);

    T get(I id);

    T add(T entity);

    T update(T entity);

    Iterable<T> addEntities(Iterable<T> entities);

    void flushRefresh(T entity);

    void updateEntities(Iterable<T> entities);

    void remove(T entity);

    void removeById(I id);

    void removeEntities(Iterable<T> entities);

    void removeEntitiesById(Iterable<I> entityIds);

    void validate(T entity);

    void validateUniqueKey(T entity);

    void validateId(T entity, boolean isUpdate);

    boolean exists(I id);

    void trim(T entity);
}
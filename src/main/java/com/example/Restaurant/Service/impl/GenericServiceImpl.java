package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.Service.MessagesService;
import com.example.Restaurant.domain.BaseEntity;
import com.example.Restaurant.exceptions.InvalidEntityException;
import com.example.Restaurant.utils.ValidateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Implementação do GenericService.
 *
 * @param <T>
 * @param <I>
 */
@Service
public abstract class GenericServiceImpl<T extends BaseEntity<I>, I extends Serializable> implements GenericService<T, I> {

    private static final String APP_NOT_FOUND = "per.notFound";
    private static final String ID_MUST_BE_FILLED_MESSAGE = "per.id.mustBeFilled";
    private static final String ID_CANNOT_BE_FILLED_MESSAGE = "per.id.cannotBeFilled";
    private static final String ID_CONSTRAINT_VIOLATION_ON_DELETE_MESSAGE = "per.constraintViolationOnDelete";

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    protected MessagesService messagesService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    protected JpaRepository<T, I> repository;

    @Transactional
    @Override
    public T saveOrUpdate(T entity) {
        try {
            return repository.save(entity);
        } catch (ConstraintViolationException e) {
            throw new InvalidEntityException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void flushRefresh(T entity) {
        entityManager.flush();
        entityManager.refresh(entity);
    }

    @Override
    public List<T> getAll() {
        List<T> entities = repository.findAll();
        ValidateUtils.checkFound(entities, getNotFoundMessage());
        return entities;
    }

    @Override
    public Page<T> getAllPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<T> getAllPaginated(Example<T> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public T get(I id) {
        T entity = repository.findById(id).orElse(null);
        ValidateUtils.checkFound(entity, getNotFoundMessage());
        return entity;

    }

    protected String getNotFoundMessage() {
        return APP_NOT_FOUND;
    }

    protected String getIdMustBeFilledMessage() {
        return ID_MUST_BE_FILLED_MESSAGE;
    }

    protected String getIdCannotBeFilledMessage() {
        return ID_CANNOT_BE_FILLED_MESSAGE;
    }

    protected String getConstraintViolationExceptionOnDeleteMessage() {
        return ID_CONSTRAINT_VIOLATION_ON_DELETE_MESSAGE;
    }

    @Transactional
    @Override
    public T add(T entity) {
        trim(entity);
        validateId(entity, false);
        validate(entity);
        entity.setId(null);
        return this.saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public T update(T entity) {
        trim(entity);
        validateId(entity, true);
        validate(entity);
        return this.saveOrUpdate(entity);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Iterable<T> addEntities(Iterable<T> entities) {
        for (T entity : entities) {
            entity = add(entity);
        }
        return entities;
    }

    @Override
    public void updateEntities(Iterable<T> entities) {
        try {
            repository.saveAll(entities);
        } catch (ConstraintViolationException e) {
            throw new InvalidEntityException(e.getMessage());
        }
    }

    @Override
    public void remove(T entity) {
        try {
            repository.delete(entity);
        } catch (ConstraintViolationException | DataIntegrityViolationException | UnexpectedRollbackException e) {
            throw new InvalidEntityException(getConstraintViolationExceptionOnDeleteMessage());
        }
    }

    @Override
    public void removeById(I id) {
        try {
            repository.deleteById(id);
        } catch (ConstraintViolationException | DataIntegrityViolationException | UnexpectedRollbackException e) {
            throw new InvalidEntityException(getConstraintViolationExceptionOnDeleteMessage());
        }
    }

    @Override
    public void removeEntities(Iterable<T> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void removeEntitiesById(Iterable<I> entityIds) {
        for (I id : entityIds) {
            repository.deleteById(id);
        }
    }

    @Override
    public void validate(T entity) {
        validateUniqueKey(entity);
    }

    @Override
    public boolean exists(I id) {
        return repository.existsById(id);
    }

    @Override
    public void validateId(T entity, boolean isUpdate) {
        if (isUpdate) {
            ValidateUtils.checkBiggerThanZero(Long.parseLong(String.valueOf(entity.getId())), getIdMustBeFilledMessage());
        } else {
            ValidateUtils.checkMustBeNullOrZero((Integer) entity.getId(), getIdCannotBeFilledMessage());
        }
    }

    @Override
    public void validateUniqueKey(T entity) {
    }
}
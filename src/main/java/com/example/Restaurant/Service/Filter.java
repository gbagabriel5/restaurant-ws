package com.example.Restaurant.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Filter<T>{

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    private CriteriaQuery criteriaQuery;
    private Root root;
    private TypedQuery query;

    protected void initialize(Class<T> c){
        criteriaBuilder = entityManager.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(c);
        root = criteriaQuery.from(c);
    }

    public Filter(EntityManager entityManager){
        setEntityManager(entityManager);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return criteriaBuilder;
    }

    public CriteriaQuery getCriteriaQuery() {
        return criteriaQuery;
    }

    public Root getRoot() {
        return root;
    }

    public TypedQuery getQuery() {
        return query;
    }

    public void setQuery(TypedQuery typedQuery) {
        this.query = typedQuery;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

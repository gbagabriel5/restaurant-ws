package com.example.Restaurant.domain;

import com.example.Restaurant.Service.GenericFilter;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class FilterManagerAbstract {

    protected GenericFilter classFilter;

    protected List<Predicate> predicates = new ArrayList<>();

    protected HashMap<ParameterExpression<?>, Object> parameters = new HashMap<>();

    protected List<Order> orders = new ArrayList<>();

    protected Path path;
}

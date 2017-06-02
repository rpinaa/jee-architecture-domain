package org.com.rappid.repository.jpa.impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.com.rappid.repository.jpa.GenericJPARepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by PINA on 24/05/2017.
 */
public abstract class GenericJPARepositoryImpl<T, ID extends Serializable> implements GenericJPARepository<T, ID> {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected final Class<T> persistentClass;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected Object entityManagerFactory;

    @SuppressWarnings("unchecked")
    public GenericJPARepositoryImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void insert(final T entity) {

    }

    @Override
    public void update(final T entity) {

    }

    @Override
    public T findById(final ID id) {
        return null;
    }

    @Override
    public T delete(final ID id) {
       return null;
    }

    @Override
    public T delete(final T entity) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}

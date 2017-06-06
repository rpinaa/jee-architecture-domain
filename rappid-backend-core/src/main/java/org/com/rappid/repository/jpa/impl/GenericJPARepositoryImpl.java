package org.com.rappid.repository.jpa.impl;

import org.com.rappid.repository.jpa.GenericJPARepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * Created by PINA on 24/05/2017.
 */
public abstract class GenericJPARepositoryImpl<T, ID extends Serializable> implements GenericJPARepository<T, ID> {

    private final Class<T> persistentClass;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericJPARepositoryImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(T) FROM " + this.persistentClass.getSimpleName() + " T")
                .getResultList().size();
    }

    @Override
    public T insert(final T entity) {
        this.entityManager.persist(entity);

        return entity;
    }

    @Override
    public T update(final T entity) {
        this.entityManager.merge(entity);

        return entity;
    }

    @Override
    public T findById(final ID id) {
        return this.entityManager.find(persistentClass, id);
    }

    @Override
    public void delete(final ID id) {
        final Optional<T> entity = Optional.of(this.findById(id));

        entity.ifPresent(t -> this.entityManager.remove(t));
    }

    @Override
    public void delete(final T entity) {
        this.entityManager.remove(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll(final int page, final int size) {
        return entityManager.createQuery("SELECT T FROM " + this.persistentClass.getSimpleName() + " T")
                .setFirstResult(page)
                .setMaxResults(size)
                .getResultList();
    }
}

package org.com.rappid.repository.jpa.impl;

import org.com.rappid.repository.jpa.GenericJPARepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

/**
 * Created by PINA on 24/05/2017.
 */

public abstract class GenericJPARepositoryImpl<T extends Serializable, ID> implements GenericJPARepository<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public GenericJPARepositoryImpl() {

        Type type = getClass().getGenericSuperclass();

        while (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != GenericJPARepositoryImpl.class) {
            if (type instanceof ParameterizedType) {
                type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
            } else {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }

        this.persistentClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

    @Override
    public long count() {
        return (long) this.entityManager.createQuery("SELECT COUNT(T) FROM " + this.persistentClass
                .getSimpleName() + " T")
                .getSingleResult();
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
    public T findOne(final ID id) {
        return this.entityManager.find(this.persistentClass, id);
    }

    @Override
    public void delete(final ID id) {
        final Optional<T> entity = Optional.of(this.findOne(id));

        entity.ifPresent(t -> this.entityManager.remove(t));
    }

    @Override
    public void delete(final T entity) {
        this.entityManager.remove(entity);
    }

    @Override
    public void deleteAll() {
        this.entityManager.createQuery("DELETE FROM " + this.persistentClass
                .getSimpleName() + " T")
                .executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll(final int page, final int size) {
        return this.entityManager.createQuery("SELECT T FROM " + this.persistentClass
                .getSimpleName() + " T")
                .setFirstResult(page)
                .setMaxResults(size)
                .getResultList();
    }
}

package org.com.rappid.repository.jpa;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PINA on 24/05/2017.
 */
public interface GenericJPARepository<T, ID extends Serializable> {

    void insert(final T entity);

    void update(final T entity);

    T findById(final ID id);

    T delete(final ID id);

    T delete(final T entity);

    List<T> findAll();
}

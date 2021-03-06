package org.com.rappid.repository.jpa;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PINA on 24/05/2017.
 */
public interface GenericJPARepository<T extends Serializable, ID> {

    long count();

    T insert(final T entity);

    T update(final T entity);

    T findOne(final ID id);

    void delete(final ID id);

    void delete(final T entity);

    void deleteAll();

    List<T> findAll(final int page, final int size);
}

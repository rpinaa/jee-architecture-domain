package org.com.rappid.mapper.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by PINA on 25/05/2017.
 */
public interface GenericMapper<F, T extends Serializable> {

    T map(final F from);

    F map(final T from);

    Future<F> map(final Future<T> from);

    List<T> mapList(final List<F> from);

    List<F> mapListReverse(final List<T> from);

    Future<List<T>> mapList(final Future<List<F>> from);

    Future<List<F>> mapListReverse(final Future<List<T>> from);
}

package org.com.rappid.mapper.jpa.impl;

import org.com.rappid.mapper.jpa.DozerMapper;
import org.com.rappid.mapper.jpa.GenericMapper;

import javax.ejb.AsyncResult;
import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by PINA on 25/05/2017.
 */
public abstract class GenericMapperImpl<F, T extends Serializable> implements GenericMapper<F, T> {

    private final Class<F> fromClass;
    private final Class<T> toClass;

    @Inject
    private DozerMapper genericDozerMapper;

    @SuppressWarnings("unchecked")
    public GenericMapperImpl() {
        this.fromClass = (Class<F>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.toClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public T map(final F from) {
        return this.genericDozerMapper.getMapper().map(from, this.toClass);
    }

    @Override
    public F map(final T from) {
        return this.genericDozerMapper.getMapper().map(from, this.fromClass);
    }

    @Override
    public Future<F> map(final Future<T> from) {
        return Optional.of(from).map(f -> {
            try {
                return new AsyncResult<>(this.map(f.get()));
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }).orElse(null);
    }

    public List<T> mapList(final List<F> from) {
        return Optional.of(from).orElse(null).stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public Future<List<T>> mapList(final Future<List<F>> from) {
        return Optional.of(from).map(f -> {
            try {
                return new AsyncResult<>(this.mapList(f.get()));
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }).orElse(null);
    }

    @Override
    public List<F> mapListReverse(final List<T> from) {
        return Optional.of(from).orElse(null).stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public Future<List<F>> mapListReverse(final Future<List<T>> from) {
        return Optional.of(from).map(f -> {
            try {
                return new AsyncResult<>(this.mapListReverse(f.get()));
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }).orElse(null);
    }
}
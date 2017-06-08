package org.com.rappid.mapper.jpa;

import javax.ejb.AsyncResult;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by PINA on 25/05/2017.
 */

public interface GenericMapper<F, T extends Serializable> {

    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    T map(final F from);

    F map(final T from);

    default T map(final F from, final Class<?> ... groups) {

        final T t = this.map(from);

        final Set<ConstraintViolation<Object>> constraintsViolations = validator.validate(t, groups);

        if (constraintsViolations.size() > 0) {
            throw new RuntimeException(constraintsViolations.toString());
        }

        return t;
    }

    default Future<F> map(final Future<T> from) {
        return Optional.of(from).map(f -> {
            try {
                return new AsyncResult<>(this.map(f.get()));
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }).orElse(null);
    }

    default List<T> mapList(final List<F> from) {
        return Optional.of(from).orElse(null).stream().map(this::map).collect(Collectors.toList());
    }

    default Future<List<T>> mapList(final Future<List<F>> from) {
        return Optional.of(from).map(f -> {
            try {
                return new AsyncResult<>(this.mapList(f.get()));
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }).orElse(null);
    }

    default List<F> mapListReverse(final List<T> from) {
        return Optional.of(from).orElse(null).stream().map(this::map).collect(Collectors.toList());
    }

    default Future<List<F>> mapListReverse(final Future<List<T>> from) {
        return Optional.of(from).map(f -> {
            try {
                return new AsyncResult<>(this.mapListReverse(f.get()));
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }).orElse(null);
    }
}

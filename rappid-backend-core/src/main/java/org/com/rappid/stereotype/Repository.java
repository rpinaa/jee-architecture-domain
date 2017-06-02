package org.com.rappid.stereotype;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by PINA on 24/05/2017.
 */

@Qualifier
@Target({ TYPE, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Repository {
}

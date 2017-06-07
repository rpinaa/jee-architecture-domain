package org.com.rappid.stereotype;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by PINA on 24/05/2017.
 */

@Qualifier
@Target({ METHOD, FIELD, TYPE })
@Retention(RUNTIME)
@Documented
public @interface Repository {
}

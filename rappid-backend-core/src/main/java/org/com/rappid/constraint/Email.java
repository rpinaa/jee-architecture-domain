package org.com.rappid.constraint;

import org.com.rappid.constraint.impl.EmailImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by PINA on 09/06/2017.
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailImpl.class)
@Documented
public @interface Email {

    String message() default "Email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

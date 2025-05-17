package org.timofeeva.subman.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValue {

    String message();

    Class<?> referenceClass();

    String referenceField();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

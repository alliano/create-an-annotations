package com.customvalidator.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberUniqueConstraintValidator.class)
public @interface NumberUniqueConstraint {

   String message();

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

}

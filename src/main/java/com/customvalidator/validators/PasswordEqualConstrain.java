package com.customvalidator.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * @Target({}) => ini untuk mennetukan annotasi ini level nya di mna ci class atau di properi atau di method
 * @Retention() => ini untuk memnentukan annotasi ini akan di eksekusi saat kapan saat runtime atau saat kompilasi dan lain lain
 * @Documented => ini untuk dokumntasi nantinya
 * @Constraint() => ini untuk menentukan annotasi ini di validasi oleh class yang mna
 * logic dari annotasi ini ada di annotasi @Constrain
 * @author alliano
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordEqualConstrainValidator.class)
public @interface PasswordEqualConstrain {

   String message();

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}

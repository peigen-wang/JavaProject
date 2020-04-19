package com.commom.validation;

import com.commom.validation.impl.Phone;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author peigen
 */
@Constraint(validatedBy = Phone.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PhoneAnnotation {
    String message() default "";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

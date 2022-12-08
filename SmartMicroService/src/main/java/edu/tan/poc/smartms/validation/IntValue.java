/**
 * 
 */
package edu.tan.poc.smartms.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author tanmo
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntegerValidator.class)
@Documented
public @interface IntValue {
	String message() default "{Integer.invalid}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}

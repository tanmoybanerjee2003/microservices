/**
 * 
 */
package edu.tan.poc.smartms.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import edu.tan.poc.smartms.error.ValidationFailure;
import edu.tan.poc.smartms.vo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@Component("userValidator")
public class UserValidator implements Validator {
	private final boolean isDebugEnabled = log.isDebugEnabled();

	@Override
	public List<ValidationFailure> validate(Object obj) {
		List<ValidationFailure> validationFailures = new ArrayList<>();
		
		if(obj != null) {
			User user = (User) obj;
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			javax.validation.Validator validator = validatorFactory.getValidator();
			Set<ConstraintViolation<User>> violations = validator.validate(user);
			for(ConstraintViolation<User> violation : violations) {
				ValidationFailure validationFailure = new ValidationFailure();
				validationFailure.setField(violation.getPropertyPath().toString());
				validationFailure.setDescription(violation.getMessage());
				validationFailures.add(validationFailure);
			}
			if(isDebugEnabled && !validationFailures.isEmpty()) {
				log.debug("Validation error coming for this payload: " + user);
			}
		} else {
			log.info("No validation performed for null object.");
		}
		
		return validationFailures;
	}

}

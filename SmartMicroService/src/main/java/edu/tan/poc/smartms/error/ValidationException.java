/**
 * 
 */
package edu.tan.poc.smartms.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tanmo
 *
 */
@AllArgsConstructor
@Getter
@Setter
public class ValidationException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8776534026778714994L;
	private List<ValidationFailure> validationFailures;
	
	public ValidationException(BindingResult bindingResult) {
		validationFailures = new ArrayList<>();
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			ValidationFailure validationFailure = new ValidationFailure();
			validationFailure.setField(fieldError.getField());
			validationFailure.setDescription(fieldError.getDefaultMessage());
			validationFailures.add(validationFailure);
		}
	}
}

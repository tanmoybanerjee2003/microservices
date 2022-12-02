/**
 * 
 */
package edu.tan.poc.smartms.validation;

import java.util.List;

import edu.tan.poc.smartms.error.ValidationFailure;

/**
 * @author tanmo
 *
 */
public interface Validator {
	public List<ValidationFailure> validate(Object obj);
}

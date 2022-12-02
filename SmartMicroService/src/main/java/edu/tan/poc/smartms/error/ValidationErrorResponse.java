/**
 * 
 */
package edu.tan.poc.smartms.error;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tanmo
 *
 */
@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse {
	private List<ValidationFailure> validationFailures;
}

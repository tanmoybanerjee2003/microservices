/**
 * 
 */
package edu.tan.poc.smartms.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@ControllerAdvice
public class AppExceptionHandler {
	private static final String INVALID_INPUT_PARAM = "Input parameter is invalid";
	private static final String VALIDATION_ERROR = "Validation error";
	private static final String INTERNAL_SERVER_ERROR = "Internal server error";
	private final boolean isDebugEnabled = log.isDebugEnabled();
	
	@ExceptionHandler(value = ValidationException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Object> handleInvalidPayloadException(Exception ex, WebRequest request) {
		if(isDebugEnabled) {
			log.debug("Controller advice for validation exception.");
		}
		ErrorResponse error = new ValidationErrorResponse();
		error.setType(VALIDATION_ERROR);
		error.setMessage(INVALID_INPUT_PARAM);
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		((ValidationErrorResponse)error).setValidationFailures(((ValidationException) ex).getValidationFailures());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public final ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
		if(isDebugEnabled) {
			log.debug("Controller advice for exception.");
		}
		ErrorResponse error = new ErrorResponse();
		error.setType(INTERNAL_SERVER_ERROR);
		error.setMessage(ex.getLocalizedMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

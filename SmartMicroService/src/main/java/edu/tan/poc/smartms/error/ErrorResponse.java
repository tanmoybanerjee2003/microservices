/**
 * 
 */
package edu.tan.poc.smartms.error;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tanmo
 *
 */
@Getter
@Setter
public class ErrorResponse {
	protected String message;
	protected String type;
	protected Integer status;
}

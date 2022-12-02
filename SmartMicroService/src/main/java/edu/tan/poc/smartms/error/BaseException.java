/**
 * 
 */
package edu.tan.poc.smartms.error;

/**
 * @author tanmo
 *
 */
public class BaseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8080777179052385802L;

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}
}

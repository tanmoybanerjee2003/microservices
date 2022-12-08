/**
 * 
 */
package edu.tan.poc.smartms.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import edu.tan.poc.smartms.validation.IntValue;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tanmo
 *
 */
@Getter
@Setter
@ToString
public class User {
	@IntValue(message = "Value of userId is invalid")
	private String userId;
	@NotBlank
	@Size(max = 255, message = "firstName is too long")
	private String firstName;
	@Size(max = 255, message = "middleName is too long")
	private String middleName;
	@Size(max = 255, message = "lastName is too long")
	private String lastName;
}

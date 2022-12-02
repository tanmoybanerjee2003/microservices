/**
 * 
 */
package edu.tan.poc.smartms.vo;

import javax.validation.constraints.NotBlank;

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
	private String userId;
	@NotBlank
	private String firstName;
	private String middleName;
	private String lastName;
}

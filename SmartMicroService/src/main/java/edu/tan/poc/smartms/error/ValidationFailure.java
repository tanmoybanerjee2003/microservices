/**
 * 
 */
package edu.tan.poc.smartms.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author tanmo
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ValidationFailure {
	@JsonProperty("field")
	private String field;
	@JsonProperty("description")
	private String description;
	
	/*
	 * Convert given object to string with each line intended by 4 spaces
	 */
	private String toIntentedString(Object obj) {
		if(obj == null) {
			return "null";
		}
		return obj.toString().replace("\n", "\n    ");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ValidationFailure {\n")
			.append("    field: ").append(toIntentedString(field)).append("\n")
			.append("    description: ").append(toIntentedString(description)).append("\n")
			.append("}");
		
		return sb.toString();
	}
}

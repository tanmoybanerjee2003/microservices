/**
 * 
 */
package edu.tan.poc.smartms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import edu.tan.poc.smartms.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@Component
public class IntegerValidator implements ConstraintValidator<IntValue, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		/*
		 * This validator will check only if a value is present
		 */
		if(CommonUtil.isEmpty(value)) {
			return true;
		}
		
		try {
			CommonUtil.intValue(value);
		} catch(Exception ex) {
			log.error("Error in validating integers", ex);
			return false;
		}
		
		
		return true;
	}

}

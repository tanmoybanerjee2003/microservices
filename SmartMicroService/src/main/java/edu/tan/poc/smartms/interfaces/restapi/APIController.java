/**
 * 
 */
package edu.tan.poc.smartms.interfaces.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.tan.poc.smartms.error.ValidationException;
import edu.tan.poc.smartms.error.ValidationFailure;
import edu.tan.poc.smartms.service.UserService;
import edu.tan.poc.smartms.validation.Validator;
import edu.tan.poc.smartms.vo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@RestController
public class APIController {
	private final boolean isDebugEnabled = log.isDebugEnabled();
	
	@Autowired
	private Validator userValidator;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/ping")
	public String ping() {
		if(isDebugEnabled) {
			log.debug("Ping is successful.");
		}
		return "ALIVE";
	}
	
	@PostMapping(path = "/user")
	public ResponseEntity<User> create(@RequestBody User user) {
		if(user != null) {
			if(isDebugEnabled) {
				log.debug("Received user information: {}", user);
			}
			//validate
			List<ValidationFailure> validationFailures = userValidator.validate(user);
			if(!validationFailures.isEmpty()) {
				throw new ValidationException(validationFailures);
			}
			
			//save
			userService.save(user);
		} else {
			log.error("Null or empty payload is ignored.");
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}

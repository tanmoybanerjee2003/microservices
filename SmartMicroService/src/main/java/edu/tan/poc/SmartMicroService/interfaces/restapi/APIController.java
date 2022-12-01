/**
 * 
 */
package edu.tan.poc.SmartMicroService.interfaces.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@RestController
public class APIController {
	private final boolean isDebugEnabled = log.isDebugEnabled();
	
	@GetMapping(path = "/ping")
	public String ping() {
		if(isDebugEnabled) {
			log.debug("Ping is successful.");
		}
		return "ALIVE";
	}

}

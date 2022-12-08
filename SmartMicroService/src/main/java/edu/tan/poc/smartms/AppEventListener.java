/**
 * 
 */
package edu.tan.poc.smartms;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@Component
public class AppEventListener {
	private final boolean isDebugEnabled = log.isDebugEnabled();
	
	@EventListener
	public void onApplicationEvent(ApplicationReadyEvent event) {
		if(isDebugEnabled) {
			log.debug("Received applicationReadyEvent");
		}
		
		//perform on-startup tasks
		
		if(isDebugEnabled) {
			log.debug("Microservice has been started successfully.");
		}
	}
}

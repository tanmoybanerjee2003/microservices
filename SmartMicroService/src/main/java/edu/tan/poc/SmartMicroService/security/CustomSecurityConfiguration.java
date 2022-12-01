/**
 * 
 */
package edu.tan.poc.SmartMicroService.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@Configuration
public class CustomSecurityConfiguration {
	private final boolean isDebugEnabled = log.isDebugEnabled();
	
	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	private String oidcAuthServerEndPoint;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		if(isDebugEnabled) {
			log.debug("OIDC security configuration in action.");
		}
		
		httpSecurity
		.authorizeRequests()
		.antMatchers("/ping").permitAll()
		.anyRequest().authenticated().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.csrf().disable()
		.oauth2ResourceServer().jwt();
		
		return httpSecurity.build();
	}
	
	@Bean
	public JwtDecoder jwtDecoder() {
		JwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation(oidcAuthServerEndPoint);
		
		if(isDebugEnabled) {
			log.debug("Created JwtDecoder for issuer end-point: {}", oidcAuthServerEndPoint);
		}
		
		return jwtDecoder;
	}
}

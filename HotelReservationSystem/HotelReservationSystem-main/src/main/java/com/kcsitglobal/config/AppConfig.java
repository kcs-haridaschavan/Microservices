package com.kcsitglobal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/***
 * 
 * @author haridas.chavan
 *
 */
@Configuration
public class AppConfig {
	/**
	 * 
	 * @return BcryptPasswordEncoder
	 */

	@Bean
	public BCryptPasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
}

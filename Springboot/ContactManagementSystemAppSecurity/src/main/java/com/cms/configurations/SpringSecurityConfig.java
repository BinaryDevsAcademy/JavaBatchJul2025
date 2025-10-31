package com.cms.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cms.filters.JwtFilter;
import com.cms.serviceLayers.DatabaseUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	/**
	 * UsernamePasswordAuthenticationFilter : It is the very filter which will be used to authenticate crenditals
	 * AutenticationManager : Manages the providers
	 * AuthenticationProvider : Provides the original data from source
	 * UserDetails : carries the info from one layer to another layer
	 * **/
	
	@Autowired
	private DatabaseUserDetailsService dbUserDetails;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
		return https.csrf(Customizer -> Customizer.disable())
				.authorizeHttpRequests(http -> {
					http.requestMatchers("/", "/signup", "/all", "/login").permitAll() //accepts without authentication
					.anyRequest().authenticated();
				})
				.formLogin(Customizer -> Customizer.disable())
				.httpBasic(Customizer.withDefaults())
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
	
	@Bean
	public AuthenticationManager authenticationManager(PasswordEncoder encoder) {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(dbUserDetails);
		authProvider.setPasswordEncoder(encoder);
		return new ProviderManager(authProvider);
	}
	
}

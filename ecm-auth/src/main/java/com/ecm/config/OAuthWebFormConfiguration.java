package com.ecm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class OAuthWebFormConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/activated").setViewName("activated");
		registry.addViewController("/failure").setViewName("failure");
		
	}

	@Configuration
	@Order(-20)
	protected static class LoginConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;
		
		@Override
		public void configure(WebSecurity web) throws Exception {
		    web.ignoring().antMatchers("/register","/postregister","/activate");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			
			http.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.requestMatchers()
			.antMatchers("/login",  "/oauth/authorize",
					"/oauth/confirm_access").and().authorizeRequests()
			.anyRequest().authenticated();
			
			// @formatter:on
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.parentAuthenticationManager(authenticationManager);
		}
	}
}

package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 認可に対する制限をGET、POSTとも解除している
		http.authorizeRequests()
			.antMatchers("/sign-up").permitAll()
			.antMatchers().hasRole("ADMIN")
            .antMatchers().hasRole("USER")
			.anyRequest().authenticated();

		http.csrf().disable();
	}
}

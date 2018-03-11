package com.SchoolManager.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	public void globalConfiguration(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN","PROF");
//		auth.inMemoryAuthentication().withUser("student1").password("1234").roles("STUDENT");
//		auth.inMemoryAuthentication().withUser("prof1").password("1234").roles("PROF");
//		auth.inMemoryAuthentication().withUser("scolr1").password("1234").roles("SCHOLAR");
		
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal, password as credential, active from users where username=?")
		.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from users_roles where user_username=?")
		.rolePrefix("ROLE_");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/css/**, /js/**, /images/**").permitAll()
				.anyRequest()
					.authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
						.permitAll()
							.defaultSuccessUrl("/index.html");
	}
	
	
}

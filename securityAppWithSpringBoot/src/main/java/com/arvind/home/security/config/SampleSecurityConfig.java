package com.arvind.home.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.arvind.home.repository.ReaderRepository;

@Configuration
@EnableWebSecurity
public class SampleSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ReaderRepository readerRepository;
	
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.sessionManagement()
		http
			.authorizeRequests()
			.antMatchers("/api/**").permitAll()
			.anyRequest().authenticated()
//		.and()
//			.csrf().csrfTokenRepository(csrfTokenRepository())
		.and()
			.httpBasic()
		.and()
			.formLogin()
		.and()
			.logout()
			.permitAll();
	}
	
//	private CsrfTokenRepository csrfTokenRepository() 
//	{ 
//	    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository(); 
//	    repository.setSessionAttributeName("_csrf");
//	    return repository; 
//	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return readerRepository.findOne(username);
			}
		});
	}
}

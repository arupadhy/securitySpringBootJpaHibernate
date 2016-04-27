//package com.arvind.home.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.arvind.home.repository.ReaderRepository;
//
//@Configuration
//@EnableWebSecurity
//public class SampleSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private ReaderRepository readerRepository;
//	
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/reading/").access("hasRole('READER')") //only READER role should have access to home page.
//		.antMatchers("/").permitAll() //anyone can access all other pages in the application
//		
//		.and()
//		
//		.formLogin();
////		.loginPage("/login")  //login details for the page
////		.failureUrl("/login?error=true");
//	}
//	
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(new UserDetailsService() {
//			
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				return readerRepository.findOne(username);
//			}
//		});
//	}
//}

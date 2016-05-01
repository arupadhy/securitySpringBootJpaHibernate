package com.arvind.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SecurityAppWithSpringBootApplication {	

	public static void main(String[] args) {
		SpringApplication.run(SecurityAppWithSpringBootApplication.class, args);
	}
	
	
	
//	@ControllerAdvice
//    static class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
//        public JsonpAdvice() {
//            super("callback");
//        }
//    }
	
}

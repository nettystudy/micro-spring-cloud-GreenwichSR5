package com.zhht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootStrapApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BootStrapApplication.class, args);
		new SpringApplicationBuilder(BootStrapApplication.class).web(WebApplicationType.SERVLET).run(args);
	}
	
/*	@EnableWebSecurity
	static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().ignoringAntMatchers("/**").and().authorizeRequests().anyRequest()
	                .authenticated().and().httpBasic();
	    }
	}*/
}


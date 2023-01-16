package com.zhht.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//关闭csrf
//		http.csrf().disable();
		//开启认证
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//		http.csrf().ignoringRequestMatchers(requestMatchers)
		http.csrf().ignoringAntMatchers("/eureka/**");
		super.configure(http);
	}
}

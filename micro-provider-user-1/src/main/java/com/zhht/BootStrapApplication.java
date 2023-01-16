package com.zhht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableDiscoveryClient或 @EnableEurekaClient ，从Edgware开始，该注解可省略。
 * @author quan
 *
 */
@SpringBootApplication
@EnableEurekaClient 
public class BootStrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootStrapApplication.class, args);
	}
}

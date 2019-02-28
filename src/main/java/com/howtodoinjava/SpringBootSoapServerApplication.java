package com.howtodoinjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootSoapServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapServerApplication.class, args);
	}
}


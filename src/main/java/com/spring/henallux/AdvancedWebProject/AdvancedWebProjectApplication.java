package com.spring.henallux.AdvancedWebProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AdvancedWebProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedWebProjectApplication.class, args);
	}

}

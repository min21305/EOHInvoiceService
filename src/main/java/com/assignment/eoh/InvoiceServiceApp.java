package com.assignment.eoh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@RestController
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "com.assignment.*" })
public class InvoiceServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceServiceApp.class, args);
	}

}

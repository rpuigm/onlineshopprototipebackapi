package net.ectemplate.app.showcases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EctemplateServiceShowcasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EctemplateServiceShowcasesApplication.class, args);
	}

}

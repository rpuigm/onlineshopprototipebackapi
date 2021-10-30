package net.ectemplate.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EctemplateServicioGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EctemplateServicioGetwayApplication.class, args);
	}

}

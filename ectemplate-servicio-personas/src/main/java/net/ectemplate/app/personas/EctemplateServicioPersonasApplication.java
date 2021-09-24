package net.ectemplate.app.personas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EctemplateServicioPersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EctemplateServicioPersonasApplication.class, args);
	}

}

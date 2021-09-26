package net.ectemplate.app.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EctemplateServicioClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EctemplateServicioClientesApplication.class, args);
	}

}

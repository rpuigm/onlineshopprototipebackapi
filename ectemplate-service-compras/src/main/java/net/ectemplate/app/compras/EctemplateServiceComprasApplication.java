package net.ectemplate.app.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EctemplateServiceComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EctemplateServiceComprasApplication.class, args);
	}

}

package com.ostemplate.app.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OstemplateServicioEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OstemplateServicioEurekaServerApplication.class, args);
	}

}

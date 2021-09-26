package net.ectemplate.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EctemplateServiceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EctemplateServiceConfigServerApplication.class, args);
	}

}

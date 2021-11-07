package net.ectemplate.app.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class EctemplateServiceOauthApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	public static void main(String[] args) {
		SpringApplication.run(EctemplateServiceOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password="12345";
		
		for(int i=0; i<4; i++) {
			String passworddBCrypt= passwordEncode.encode(password);
			System.out.println(passworddBCrypt);
			
		}
		
	}

}

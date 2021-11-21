package net.ectemplate.app.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class EctemplateServiceZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EctemplateServiceZuulServerApplication.class, args);
	}
	


}

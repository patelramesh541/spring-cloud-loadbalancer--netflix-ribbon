package io.rock.ribbontimeapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RibbonTimeAppApplication {

	@Inject
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeAppApplication.class, args);
	}

	@GetMapping
	public String getTime() {
		return  restTemplate.getForEntity("http://time-service", String.class).getBody();
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

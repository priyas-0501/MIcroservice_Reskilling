package com.ibm.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceMsApplication.class, args);
	}

}

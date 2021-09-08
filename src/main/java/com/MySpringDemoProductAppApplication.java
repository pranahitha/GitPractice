package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
						//optional if we  added dependency of discovery client
public class MySpringDemoProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringDemoProductAppApplication.class, args);
		/*
		 * SpringApplication application = new
		 * SpringApplication(MySpringDemoProductAppApplication.class);
		 * application.setAdditionalProfiles("native"); application.run(args);
		 */
	}

}

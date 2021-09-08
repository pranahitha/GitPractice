package com.revature.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties("company")
@Component
public class Company {
	
	private String companyName;
	private String companyLocation;
	private String companyAddress;
	

}

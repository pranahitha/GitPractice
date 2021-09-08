package com.revature.model;

import lombok.Data;

@Data
public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerAddress;
	private int billAmount;

}

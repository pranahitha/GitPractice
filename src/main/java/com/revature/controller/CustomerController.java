package com.revature.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Customer;


@RestController
@RequestMapping("customer")
public class CustomerController {

	@GetMapping
	public List<Customer> getCustomers()
	{
		System.out.println("All customers called");
		return null;
	}
	
	@GetMapping("{customerId}")
	public List<Customer> getCustomerById(@PathVariable("customerId")int pId)
	{
		System.out.println("CUSTOMER BY ID is called "+pId);
		return null;
	}
	@GetMapping("/searchByName/{customerName}")
	public List<Customer> getCustomerByName(@PathVariable("customerName")String pName)
	{
		System.out.println("CUSTOMER BY Name is  "+pName);
		return null;
	}
	@PostMapping
	public String addCustomer(@RequestBody Customer customer)
	{
		System.out.println("add customer called");
		System.out.println(customer);
		return null;
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		System.out.println("PUT customers called");
		System.out.println(customer);
		return null;
	}
	@DeleteMapping("{customerId}")
	public Customer deleteProduct(@PathVariable("customerId")int pId)
	{
		System.out.println("DELETE customers called "+pId);

		return null;
	}
	
}

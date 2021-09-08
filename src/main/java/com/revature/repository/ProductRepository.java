package com.revature.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.model.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>
{
	//select * from
	public List<Product>findByProductName(String productName);
	public List<Product>findByQuantityOnHand(int quantityOnHand);
	public List<Product>findByQuantityOnHandGreaterThan(int quantityOnHand);
	public List<Product>findByQuantityOnHandLessThan(int quantityOnHand);
	public List<Product>findByPriceBetween(int lowerPrice,int upperPrice);
	//public List<Product>findByProductNameLikeAndPriceBetween(String productName,int lowerPrice,int upperPrice);
	
}

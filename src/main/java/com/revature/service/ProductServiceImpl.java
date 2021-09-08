package com.revature.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Product;
import com.revature.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	@Transactional(propagation = Propagation.NEVER)
	@Override
	public boolean addProduct(Product product) {
		System.out.println("---- add product called -Service");
		productRepository.save(product);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteProduct(int productId) {
		System.out.println("--- delete product called - Service");
		productRepository.deleteById(productId);
		return true;
	}
	
	@Transactional(propagation = Propagation.NESTED)
	@Override
	public boolean updateProduct(Product product) {
		System.out.println("----- update product called -Service");
		productRepository.save(product);
		return true;
	}

	@Transactional(readOnly = true)
	@Override
	public Product getProductById(int productId) {
		System.out.println("----- product by id called -Service");
		Optional<Product> productData = productRepository.findById(productId);
		Product product = productData.get();
		return product;
	}

	@Transactional
	@Override
	public List<Product> getProductByName(String productName) {
		return productRepository.findByProductName(productName);
	}

	@Transactional
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Transactional(propagation = Propagation.NEVER)
	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> productData = productRepository.findById(productId);
			return productData.isPresent();
	}

	@Transactional
	@Override
	public List<Product> getProductByPrice(int lowerPrice, int upperPrice) {
		
		return productRepository.findByPriceBetween(lowerPrice, upperPrice);
	}
	/*
	 * @Override public List<Product> getProductByNameRange(String productName, int
	 * lowerPrice, int upperPrice) { return
	 * productRepository.findByProductNameLikeAndPriceBetween(productName,
	 * lowerPrice, upperPrice); }
	 */

	
	 
	
}

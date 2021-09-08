package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Product;
import com.revature.repository.ProductRepository;
import com.revature.service.ProductService;



@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product product)
	{
		ResponseEntity<String> responseEntity = null;
		int productId = product.getProductId();
		String msg = null;
		if(productService.isProductExists(productId))
		{
			msg="Product with product id : "+productId+" already exists";
			responseEntity = new ResponseEntity<String>(msg,HttpStatus.OK);
			
		}
		else
		{
			productService.addProduct(product);
			msg="Product with product id :"+productId+" saved successfully";
			responseEntity = new ResponseEntity<String>(msg,HttpStatus.OK);
			
		}
		return responseEntity;
	}
	
	
	
		@GetMapping
		public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false)String productName)
		{
			ResponseEntity<List<Product>> responseEntity = null;
			List <Product> products = new ArrayList<Product>();
			if(productName == null)
			{
				products = productService.getAllProducts();
			}else
			{
				products = productService.getProductByName(productName);
			}
			if(products.size() == 0)
			{
				responseEntity = new ResponseEntity<List <Product>>(products,HttpStatus.NO_CONTENT);
				
			}
			else
			{
				responseEntity = new ResponseEntity<List <Product>>(products,HttpStatus.OK);
				
			}
			return responseEntity;
		}
			
		


		@GetMapping("{productId}")
		public ResponseEntity<Product> getProductById(@PathVariable("productId")int productId)
		{
			ResponseEntity<Product> responseEntity = null;
			Product product =new Product();
			if(productService.isProductExists(productId))
			{
				product = productService.getProductById(productId);
				responseEntity = new ResponseEntity<Product>(product,HttpStatus.OK);
			}
			else
			{

				responseEntity = new ResponseEntity<Product>(product,HttpStatus.OK);
			}
			return responseEntity;
		}
		
		/*
		 * @PostMapping public String addProduct(@RequestBody Product product) {
		 * System.out.println("add products called"); System.out.println(product);
		 * productService.addProduct(product); return null; }
		 */
		
		@PutMapping
		public ResponseEntity<String> updateProduct(@RequestBody Product product)
		{
			ResponseEntity<String> responseEntity = null;
			int productId = product.getProductId();
			String message=null;
			if(productService.isProductExists(productId))
			{
			productService.updateProduct(product);
			message = "Product with product id : "+productId+" updated";
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
			}
			else
			{
				message = "Product with product id : "+productId+" does not exists";
				responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		}
			return responseEntity;
		}

		
		@DeleteMapping("{productId}")
		public ResponseEntity<String> deleteProduct(@PathVariable("productId")int productId)
		{
			ResponseEntity<String> responseEntity = null;
			String message = null;
			if(productService.isProductExists(productId))
			{
				productService.deleteProduct(productId);
				message = "Product with product Id : "+productId+" deleted successfully";
				responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
			}
			else
			{

				responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
			}
			return responseEntity;
		}
		
		@GetMapping("/searchByName/{productName}")
		public List<Product> getProductByName(@PathVariable("productName")String pName)
		{
			System.out.println("PRODUCT BY Name is  "+pName);
			return productService.getProductByName(pName);
		}
		
		@GetMapping("/filterSearchByPrice/{lowerPrice}/{upperPrice}")
		public List<Product> getProductByPrice(
				@PathVariable("lowerPrice")int lowerPrice,
				@PathVariable("upperPrice")int upperPrice)
		{
			
			return productService.getProductByPrice(lowerPrice, upperPrice);
		}
		///
		/*
		 * @GetMapping("{productName}/range/{lowerPrice}/{upperPrice}") public
		 * List<Product> getProductByNameRange(
		 * 
		 * @PathVariable("productName")String productName,
		 * 
		 * @PathVariable("lowerPrice")int lowerPrice,
		 * 
		 * @PathVariable("upperPrice")int upperPrice) { return
		 * productService.getProductByNameRange(productName, lowerPrice, upperPrice); }
		 */
		
}


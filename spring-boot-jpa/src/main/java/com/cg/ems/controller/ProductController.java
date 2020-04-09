package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entity.Employee;
import com.cg.ems.entity.Product;
import com.cg.ems.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("product")
	public ResponseEntity<List<Product>>  findAllProducts()
	{
	  
		List<Product> list = productService.findAllProducts();
		ResponseEntity<List<Product>>  rt = new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		return rt;
		
	}
	
	
	@GetMapping("product/{id}")
	public ResponseEntity<List<Product>> findProductById(@PathVariable("id") int productId)
	{
		Product pro=productService.findAllProductsById(productId);
		
		ResponseEntity rt= new ResponseEntity<Product>(pro,HttpStatus.OK);
		
		return rt;
	}
	
	
	@DeleteMapping("product/{id}")
	public ResponseEntity<List<Product>> deleteProductById(@PathVariable("id") int productId)
	{
		productService.deleteProductById(productId);
		
		ResponseEntity rt=new ResponseEntity<Product>(HttpStatus.OK);
		return rt;
	}
	
	@PostMapping("product")
	public ResponseEntity<List<Product>> addProduct(@RequestBody Product product)
	{
		Product pro;
		pro=productService.addProduct(product);
		ResponseEntity rt= new ResponseEntity<Product>(pro,HttpStatus.OK);
		return rt;
	}
}

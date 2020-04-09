package com.cg.ems.service;

import java.util.List;

import com.cg.ems.entity.Product;

public interface ProductService {
	
	public List<Product> findAllProducts();
	public Product findAllProductsById(int productId);
	public Product addProduct(Product product);
	public Product deleteProductById(int productId);

}

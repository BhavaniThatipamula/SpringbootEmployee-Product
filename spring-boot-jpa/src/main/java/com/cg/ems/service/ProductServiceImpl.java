package com.cg.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.ProductDao;
import com.cg.ems.entity.Product;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> findAllProducts() {
		
		List<Product> list=productDao.findAll();
		 
		
		return list;
	}

	@Override
	public Product findAllProductsById(int productId) {
		
		Product pro=null;
		pro=productDao.findById(productId).get();
		
		return pro;

	}

	@Override
	public Product addProduct(Product product) {
		 
		 
		productDao.saveAndFlush(product);
		
		return product;
	}

	@Override
	public Product deleteProductById(int productId) {
		Product pro=null;
		pro=productDao.findById(productId).get();
		productDao.deleteById(productId);
		return pro;
	}

}

package com.project.shopping.service;

import java.util.List;
import java.util.Optional;

import com.project.shopping.entity.Product;


public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(int prod_id);
	
	public void save(Product product);
	
	public void deleteById(int id);

	public List<Product> searchBy(String name);
	
	public List<Product> findByFKey(int id);


}

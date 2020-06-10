package com.project.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.shopping.dao.ProductDao;
import com.project.shopping.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao prodDao;
	
	//RETURN ALL PRODUCT IN A BASKET
	@Override
	public List<Product> findAll() {
		return prodDao.findAll();
	}

	//FIND PRODUCT BY ID
	@Override
	public Product findById(int id) {
		Optional<Product> result = prodDao.findById(id);
		
		Product prod = null;
		if (result.isPresent()) {
			prod = result.get();
		}
		else {
			throw new RuntimeException("Did not find Product ID - " + id);
		}
		
		return prod;
		
	}
	// SAVE PRODUCT IN A BASKET
	@Override
	public void save(Product product) {
		prodDao.save(product);
	}
	// DELETE PRODUCT IN A BASKET
	public void deleteById(int id) {
		prodDao.deleteById(id);
	}

	@Override
	public List<Product> searchBy(String name) {
		
		return null;
	}

	@Override
	public List<Product> findByFKey(int id) {
		return prodDao.findAllByBasketId(id);
	}

}

package com.project.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopping.dao.BasketDao;
import com.project.shopping.entity.Basket;
import com.project.shopping.entity.Product;

@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	BasketDao dao;

	@Override
	public List<Basket> findAll() {
		return dao.findAll();
	}
	
	@Override
	public void save(Basket basket) {
		dao.save(basket);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}




}

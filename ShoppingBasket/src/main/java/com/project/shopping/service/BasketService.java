package com.project.shopping.service;

import java.util.List;

import com.project.shopping.entity.Basket;
import com.project.shopping.entity.Product;

public interface BasketService {
	public List<Basket> findAll();
	public void save(Basket basket);
	public void deleteById(int id);
}

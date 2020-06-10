package com.project.shopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.shopping.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	@Query("Select p FROM Product AS p WHERE p.basket.basket_id = :basket_id")
	List<Product> findAllByBasketId(@Param("basket_id") int basket_id);

}

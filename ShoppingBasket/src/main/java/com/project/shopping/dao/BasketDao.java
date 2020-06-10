package com.project.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopping.entity.Basket;

public interface BasketDao  extends JpaRepository<Basket, Integer>{

}

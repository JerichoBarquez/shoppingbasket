package com.project.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Table(name="product")
public class Product {
	
	@Id @GeneratedValue @Getter @Setter
	private int prod_id;
	
	@Getter @Setter
	private String prod_name;
	
	@Getter @Setter
	private String description;
	
	@Getter @Setter
	private Integer qty;
	
	@Getter @Setter
	private Double price;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="basket_basket_id", nullable=false)
	private Basket basket;
	
//	public Product(){
//		
//	}
//	public Product(Basket basket){
//		this.basket = basket;
//	}
//	@Getter @Setter
//	private int basket_basket_id;
	
	
	

}

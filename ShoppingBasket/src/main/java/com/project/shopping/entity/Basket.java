package com.project.shopping.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Basket {
	
	@Id @GeneratedValue @Getter @Setter
	private int basket_id;
	@Getter @Setter
	private String basket_name;
	
	@Getter @Setter
	@OneToMany(mappedBy="basket")
	private List<Product> list_prod;
	
	@Getter @Setter
	@Transient
	private Double tot;
	


}

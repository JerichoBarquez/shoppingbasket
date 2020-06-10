package com.project.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.shopping.entity.Basket;
import com.project.shopping.entity.Product;
import com.project.shopping.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/list")
	public String listProducts(@RequestParam("basket_id") int basket_id, Model model) {
		List<Product> theProducts = productService.findByFKey(basket_id);
		Double sum = theProducts.stream().map(x -> x.getPrice() * x.getQty()).mapToDouble(Double::valueOf).sum();
		model.addAttribute("theProducts", theProducts);
		model.addAttribute("sum", sum);
		model.addAttribute("basket_id", basket_id);
		
		return "products/list-product";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("product") Product product) {
		productService.save(product);
		return "redirect:/products/list/?basket_id=" + product.getBasket().getBasket_id();
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("prod_id") int prod_id,
									Model model) {

		Product product = productService.findById(prod_id);

		model.addAttribute("product", product);
		return "/products/product-form";	
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("basket_id") int basket_id, Model model) {
		Product product = new Product();
		Basket basket = new Basket();
		basket.setBasket_id(basket_id);
		product.setBasket(basket);
		model.addAttribute("product", product);
		return "/products/product-form";	
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("prod_id") int theId, @RequestParam("basket_id") int basket_id) {
		productService.deleteById(theId);
		return "redirect:/products/list/?basket_id=" + basket_id;
		
	}
	
	

}

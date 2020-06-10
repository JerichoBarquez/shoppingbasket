package com.project.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.shopping.entity.Basket;
import com.project.shopping.entity.Product;
import com.project.shopping.service.BasketService;
import com.project.shopping.service.ProductService;

@Controller
@RequestMapping("/baskets")
public class BasketController {

	@Autowired
	private BasketService basketService;
	@Autowired
	private ProductService productService;

	@GetMapping("/list")
	public String listBasket(Model model) {
		List<Product> listProd = null;
		Double tot = 0.0;
		Double totalShop = 0.0;
		List<Basket> theBaskets = basketService.findAll();
		for (Basket basket : theBaskets) {
			listProd = productService.findByFKey(basket.getBasket_id());
			for (Product prod : listProd) {
				tot += prod.getPrice() * prod.getQty();
			}
			totalShop += tot;
			basket.setTot(tot);
		}
		model.addAttribute("theBaskets", theBaskets);

		return "products/basket-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Basket baskets = new Basket();
		model.addAttribute("baskets", baskets);
		return "/products/basket-form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("baskets") Basket baskets) {
		basketService.save(baskets);
		return "redirect:/baskets/list";
	}
	


}

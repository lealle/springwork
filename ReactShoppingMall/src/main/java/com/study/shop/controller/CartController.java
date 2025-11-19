package com.study.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.shop.domain.Cart;
import com.study.shop.service.CartService;

@RestController
@RequestMapping("/react")
public class CartController {
	@Autowired
	CartService cService;
	
	@PostMapping("/addCart")
	public String addCart(@RequestBody Cart cart) {
		Cart cart1 = cService.insertCart(cart);
		if(cart1 != null) {
			return "ok";
		}else {
			return "fail";
		}
	}
	
	@GetMapping("/getCart")
	public List<Cart> getCart(@RequestParam("memId") String memId){
		List<Cart> cart = cService.getCart(memId);
		return cart;
	}
	
	
	
	
	
	
	
	
	
	
	
}

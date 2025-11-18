package com.study.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.shop.domain.Cart;
import com.study.shop.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cRepository;
	
	public Cart insertCart(Cart cart) {
		Optional<Cart> result = cRepository.findById(cart.getId());
		if(result.isPresent()) {
			result.get().setCount(result.get().getCount()+1);
			cRepository.save(result.get());
			return result.get();
		}else {
			cRepository.save(cart);
			return cart;
		}
	}

	public List<Cart> getCart(String memId) {
		return cRepository.findByMemId(memId);
	}

}

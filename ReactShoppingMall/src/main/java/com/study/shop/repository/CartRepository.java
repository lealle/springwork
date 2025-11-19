package com.study.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.shop.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByMemId(String memId);

	Optional<Cart> findByClothIdAndMemId(Long clothId, String memId);

}

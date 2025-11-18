package com.study.shop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cart {
	@Id
	private Long id;
	private String title;
	private String content;
	@Column(insertable=false, columnDefinition="NUMBER DEFAULT 1")
	private Long count;
	private String memId;
	
}

package com.study.shop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity(name="cart1")
public class Cart {
	@Id
	@SequenceGenerator(
			name = "s01",
			sequenceName="Shop_SEQ",  //실제 DB에 생성되는 시퀀스 이름 
			allocationSize = 1 // 1씩 증가
			)
	@GeneratedValue(generator ="s01")  // 시퀀스 : 별도의 설정이 없으면 50씩 증가
	private Long id;
	private Long clothId;
	private String title;
	private String content;
	@Column(insertable=false, columnDefinition="NUMBER DEFAULT 1")
	private Long count;
	private String memId;
	
}

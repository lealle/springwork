package com.study.springboot.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 밑의 2개는 세트로 넣어줘야함 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="JPApaging")
@Builder
public class Member {
	@Id
	@SequenceGenerator(
			name = "p01",
			sequenceName="JpaPaging_SEQ",  //실제 DB에 생성되는 시퀀스 이름 
			allocationSize = 1 // 1씩 증가
			)
	@GeneratedValue(generator ="p01")  // 시퀀스 : 별도의 설정이 없으면 50씩 증가
	private Long id;
	private String email;
	private String name;
	
	
	
	public Member(String email, String name) {
		this.name = name;
		this.email = email;
	}	
}

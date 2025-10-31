package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Boardam")
public class Board {
	@Id
	@SequenceGenerator(
			name = "b01",
			sequenceName="Boardam_SEQ",  //실제 DB에 생성되는 시퀀스 이름 
			allocationSize = 1 // 1씩 증가
			)
	@GeneratedValue(generator ="b01")  // 시퀀스 : 별도의 설정이 없으면 50씩 증가
	private Long bno;
	private String title;
	private String content;
	
	@ManyToOne
	@JoinColumn(name="writer")
	private Member member;
	
}

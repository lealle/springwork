package com.study.springboot.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Board {
	@Id
	@SequenceGenerator(
			name = "b0",
			sequenceName="Board_SEQ",  
			allocationSize = 1 
			)
	@GeneratedValue(generator ="b0")  
	private Long bno;
	
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String content;
	private String writer;
	@Column(insertable=false, columnDefinition="NUMBER DEFAULT 0")// insert할때 애 값 넣지 마세요 
	private Long count;
	
	
	@CreatedDate
	@Column(name="create_date")
	private LocalDate createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDate updateDate;
	
	
}

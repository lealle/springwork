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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Reply {
	@Id
	@SequenceGenerator(
			name = "r0",
			sequenceName="Reply_SEQ",  
			allocationSize = 1 
			)
	@GeneratedValue(generator ="r0")  
	private Long rno;
	
	@Column(nullable=false)
	private String content;

	private String writer;
	
	@CreatedDate
	@Column(name="create_date")
	private LocalDate createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDate updateDate;
	
	@Column(name="ref_bno", nullable=false)
	private Long refBno;
		
	
}

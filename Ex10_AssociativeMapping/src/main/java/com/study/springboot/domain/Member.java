package com.study.springboot.domain;


import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 밑의 2개는 세트로 넣어줘야함 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="MEMBERJPA03")
@EntityListeners(AuditingEntityListener.class)
public class Member {
	@Id
	private String id;

	// notnull 과 nullable 의 차이점 
	// notnull 은 어플리케이션에 못들어오게 하는것(DB 가기전에 오류 발생)
	// nullable 은 DB에서 사용하는 null값 
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	
	// 생성시간 수정시간 기록하기 위한 필드
	@CreatedDate()
	@Column(name="create_at")
	private LocalDateTime createAt;
	
	@LastModifiedDate
	@Column(name="update_at")
	private LocalDateTime updateAt;
	
	
}

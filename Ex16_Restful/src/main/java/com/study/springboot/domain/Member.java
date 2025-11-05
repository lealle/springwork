package com.study.springboot.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
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
// 날짜 create modified 넣으면 반드시 넣어줘야함 
@Builder
public class Member {
	@Id
	private String Id;

	@NonNull // 넣을시 NoArgsConstructor 반드시 넣어주기 관련해서 nonnull의 주의사항.txt에 저장해둠 
	@Column(nullable=false)
	private String password;
	// 여기선 오류 안나지만 데베에 넣을때 오류 발생 
	
	@NonNull
	@Column(nullable=false)
	private String name;

	private String email;
	private LocalDate birthday;
	private String gender;
	private String phone;
	private String address;
	
	@CreatedDate
	@Column(name="create_date")
	private LocalDate createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDate updateDate;
	
	


}

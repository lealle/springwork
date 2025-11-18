package com.study.shop.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="reactmember")
public class Member {
	@Id
	private String email;
	private String name;
	
	// @JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate birth;
	private String gender;
	private String phone;
	private String address;
	private String detailAddress;
	private String password;
	
	
	
	
	
	
}

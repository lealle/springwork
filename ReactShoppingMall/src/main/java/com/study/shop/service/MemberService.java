package com.study.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.study.shop.domain.Member;
import com.study.shop.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository mRepository;

	public boolean checkEmail(String email) {
		boolean mem = mRepository.existsById(email);
		if(mem) {
			return false;
		}else {
			return true;
		}
	}

	public ResponseEntity<String> save(Member m) {
		try {
			mRepository.save(m);
			return ResponseEntity.ok("회원가입 완료");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패");
		}
		
	}

	public Member login(Member m) {
		Optional<Member> member = mRepository.findByEmailAndPassword(m.getEmail(), m.getPassword());
		return member.get();
	}
}

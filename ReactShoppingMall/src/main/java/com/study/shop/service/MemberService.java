package com.study.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.shop.domain.Member;
import com.study.shop.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository mRepository;

	public boolean checkEmail(String email) {
		Optional<Member> mem = mRepository.findById(email);
		if(mem.isPresent()) {
			return false;
		}else {
			return true;
		}
	}

	public void save(Member m) {
		mRepository.save(m);
	}
}

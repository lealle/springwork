package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository mRepository;
	
	public boolean idCheck(String id) {
		return mRepository.existsById(id);
	}

	public Member insert(Member member) {
		return mRepository.save(member);
	}

	public Optional<Member> login(Member member) {
		Optional<Member> result = mRepository.findById(member.getId());
		if(result.isPresent()) {
			return result;
		}else {
			return null;
		}
	}
	
	
	
	
}

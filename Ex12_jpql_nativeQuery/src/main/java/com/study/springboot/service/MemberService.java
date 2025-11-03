package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;


@Service
public class MemberService {
	@Autowired
	MemberRepository mRepository;


	public List<Member> selectMember(String name) {
		List<Member> result = mRepository.findMembers(name);
		return result;
	}

	public List<Member> selectMember(String name, Sort sort) {
		List<Member> result = mRepository.findMembers(name, sort);
		return result;
	}

	public Page<Member> selectMember(String name, Pageable pageable) {
		Page<Member> result = mRepository.findMembers(name, pageable);
		return result;
	}

	// 일반 쿼리문 
	public List<Member> selectMember4(String name) {
		List<Member> result = mRepository.findMembersNative(name);
		return result;
	}
	



	
	
	

}

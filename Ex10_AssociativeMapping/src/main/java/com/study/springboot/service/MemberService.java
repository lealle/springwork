package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;


@Service
public class MemberService {
	@Autowired
	MemberRepository mRepository;

	public Member minsert(Member member) {
		return mRepository.save(member);
	}

	public Member mupdate(Member member) {
		if(mselectById(member.getId()) !=null) {
			Member mem = mselectById(member.getId()).get();
			mem.setUsername(member.getUsername());
			mRepository.save(mem);
			return mem;
		}else {
			return null;
		}
	}

	
	public Optional<Member> mselectById(String id) {
		Optional<Member> fID = mRepository.findById(id);
		return fID;
	}


	

}

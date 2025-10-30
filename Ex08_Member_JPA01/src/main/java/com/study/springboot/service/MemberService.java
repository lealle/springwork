package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository mRepository;
	
	public Member insert(Member member) {
		/*
		 * save() : insert할 때의 메소드
		            동일한 키가 없으면 insert, 동일한 키가 있으면 update 
		 */
		Member rMember = mRepository.save(member);
		return rMember;
	}

	/*
	 * Optional<> : NullpointerException 발생을 방지하기 위해 사용
	 */
	public Optional<Member> select(Long id) {
		Optional<Member> fID = mRepository.findById(id);
		return fID;
	}

	public List<Member> selectAll() {
		List<Member> lmem = mRepository.findAll();
		return lmem;
	}

	public int delete(Long id) {
		if(select(id) !=null) {
			mRepository.deleteById(id);
			return 1;
		}else {
			return 0;
		}
	}

	public int update(Member member) {
		if(select(member.getId()) !=null) {
			mRepository.save(member);
			return 1;
		}else {
			return 0;
		}
	}

}

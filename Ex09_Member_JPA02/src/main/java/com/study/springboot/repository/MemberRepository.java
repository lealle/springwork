package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	// findBy 뒤 컬럼명을 붙여주는 이를 이용한 검색 가능 
	List<Member> findByUsername(String username);

	Optional<Member> findByEmail(String email);

	List<Member> findByUsernameLike(String username);
	List<Member> findByUsernameLike(String username, Sort sort);

	List<Member> findByUsernameLikeOrderByUsernameDesc(String username);
	
	
// order by 2개 이면 EmailDesc 붙여주면 됨 ex) findByUsernameLikeOrderByUsernameDescEmailAsc
	
}

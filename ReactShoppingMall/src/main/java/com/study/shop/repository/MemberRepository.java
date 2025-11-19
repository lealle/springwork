package com.study.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.shop.domain.Member;

import jakarta.annotation.Nonnull;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

	Optional<Member> findByEmailAndPassword(String email, @Nonnull String password);

}

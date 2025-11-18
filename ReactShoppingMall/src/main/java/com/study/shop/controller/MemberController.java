package com.study.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.shop.domain.Member;
import com.study.shop.service.MemberService;

@RestController
@RequestMapping("/react")
public class MemberController {
	@Autowired
	MemberService mService;
	
	@GetMapping("/email-check")
	public boolean checkEmail(@RequestParam(value="email") String email) {
		return mService.checkEmail(email);
	}
	
	@PostMapping("/signup")
	public void signup(@RequestBody Member m) {
		mService.save(m);
	}
	
	
	
}

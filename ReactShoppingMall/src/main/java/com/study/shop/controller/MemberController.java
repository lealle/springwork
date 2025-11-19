package com.study.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> signup(@RequestBody Member m) {
		return mService.save(m);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Member m) {
		System.out.println(m.getEmail());
		Member mem = mService.login(m);
		if(mem != null) {
			Map<String, Object> userInfo = new HashMap<>();
			userInfo.put("name", mem.getName());
			userInfo.put("email", mem.getEmail());
			return ResponseEntity.ok(userInfo);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
			
		}
	}
	
	
	
}

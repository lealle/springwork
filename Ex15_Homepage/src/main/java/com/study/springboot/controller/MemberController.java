package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
@SessionAttributes("loginUser")// 여러개 일때는 {} 중괄호 사용하면 됨
public class MemberController {
	@Autowired
	MemberService mService;
	
	@Autowired
	PasswordEncoder pEncoder;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/enrollForm")
	public String enrollForm() {
		return "member/enrollForm";
	}
	
	@GetMapping("/idCheck")
	public @ResponseBody boolean idCheck(@RequestParam("id") String id) {
		boolean result = mService.idCheck(id);
		return result;
	}
	
	@PostMapping("/memberInsert")
	public String memberInsert(Member member) {
		String enPwd = pEncoder.encode(member.getPassword());
		member.setPassword(enPwd);
		Member mem = mService.insert(member);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Optional<Member> result = mService.login(member); // loginUser != null id 있다
		Member loginUser = result.get();
		System.out.println("이름 : " + loginUser.getName());
		if(loginUser != null  && pEncoder.matches(member.getPassword(), loginUser.getPassword())) {
			model.addAttribute("loginUser",loginUser);
			System.out.println("전화 : " + loginUser.getPhone());
			// session scopre 로 바꿔 줄려면 annotation 달아주면 됨 - SessionAttribute
		}
		
		
		return "redirect:/";
	}

	/*
		@SessionAttributes + model을 통해 로그인 정보를 관리하는 경우
		SessionStatus 객체를 통해 사용 완료 처리를 해야됨.
	*/
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		if(!status.isComplete()) {
			status.setComplete();
		}
		return "redirect:/";
	}
	
	
}

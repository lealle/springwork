package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;


@Controller
public class MemberController {
	@Autowired
	MemberService mService;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}

	@PostMapping("/minsert")
	public String minsert(Member member, Model model) {
		Member result = mService.minsert(member);
		model.addAttribute("member", result);
		return "minsert";
	}
	
	@GetMapping("/mupdate")
	public String mupdate(Member member, Model model) {
		Member result = mService.mupdate(member);
		model.addAttribute("member", result);
		return "mupdate";
	}
	
	@GetMapping("/mselect")
	public String mselectById(@RequestParam("id") String id, Model model) {
		Optional<Member> result = mService.mselectById(id);
		model.addAttribute("member", result.get());
		return "mselect";
	}
	
	
	
}

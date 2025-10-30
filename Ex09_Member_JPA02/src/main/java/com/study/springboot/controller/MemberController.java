package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(Model model) {
		mService.insert();
		return "redirect:/";
	}
	
	
	@GetMapping("/selectById")
	public String select(@RequestParam("id") Long id, Model model) {
		Optional<Member> result = mService.select(id);
		if(result.isPresent()) {
			model.addAttribute("member",result.get()); //result.get() -> Optional 을 벗겨줌 (Member)
		}else {
			model.addAttribute("member",null); 
		}
		return "selectById";
	}
	
	@GetMapping("/selectAll")
	public List<Member> selectAll(Model model) {
		List<Member> result = mService.selectAll();
		if(!(result.isEmpty())) {
			model.addAttribute("member",result); //result.get() -> Optional 을 벗겨줌 (Member)
		}else {
			model.addAttribute("member",null); 
		}
		return result;
	}
	
	

}

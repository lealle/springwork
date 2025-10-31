package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService bService;
	
	@PostMapping("/binsert")
	public String binsert(Board b, @RequestParam("id") String id,Model model) {
		Member m = new Member();
		m.setId("123");
		b.setMember(m);
		Board result = bService.binsert(b);
		model.addAttribute("board", result);
		return "binsert";
	}
	
	
	
	
}

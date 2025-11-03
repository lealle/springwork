package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	@GetMapping("/selectByNameLike1")
	public String selectByNameLike1(@RequestParam("name") String search,
										  Model model) {
		String name = search+"%";
		List<Member> result = mService.selectMember(name);

		model.addAttribute("members",result);
		System.out.println(result.size());
		return "selectByNameLike";
	}

	@GetMapping("/selectByNameLike2")
	public String selectByNameLike2(@RequestParam("name") String search,
										  Model model) {
		String name = search+"%";
		Sort sort = Sort.by(Sort.Order.asc("id"));
		List<Member> result = mService.selectMember(name, sort);

		model.addAttribute("members",result);
		System.out.println(result.size());
		return "selectByNameLike";
	}
	

	@GetMapping("/selectByNameLike3")
	public String selectByNameLike3(@RequestParam("name") String search,
									@RequestParam("page") int page,
										  Model model) {
		String name = search+"%";
		
		Sort sort = Sort.by(Sort.Order.asc("id"));
		int nPage = page-1;
		Pageable pageable = PageRequest.of(nPage,10,sort);
		Page<Member> result = mService.selectMember(name, pageable);

		List<Member> content = result.getContent();
		long totalElement = result.getTotalElements(); // 총 레코드 수 
		int totalPages= result.getTotalPages(); // 총 페이지 수 
		int size = result.getSize(); // 1페이지당 들어갈 레코드 수 
		int pageNumber = result.getNumber()+1; // 현재 페이지 (0부터 시작)
		int numberOfElement = result.getNumberOfElements(); // 현재 페이지의 레코드
		
		model.addAttribute("members",content); // 실제 객체가 담긴 List<Memer> 을 반환 
		model.addAttribute("totalElement", totalElement);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("numberOfElement", numberOfElement);
		
		
		return "selectByNameLike";
	}
	
	@GetMapping("/selectByNameLike4")
	public String selectByNameLike4(@RequestParam("name") String search,
										  Model model) {
		String name = search+"%";
		
		List<Member> result = mService.selectMember4(name);

		model.addAttribute("members", result);
		
		
		return "selectByNameLike";
	}
	
}

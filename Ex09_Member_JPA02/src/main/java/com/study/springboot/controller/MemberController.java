package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/selectByName")
	public List<Member> selectByName(@RequestParam("username") String username, Model model) {
		List<Member> result = mService.selectByUsername(username);
		if(!(result.isEmpty())) {
			model.addAttribute("member",result);
		}else {
			model.addAttribute("member",null); 
		}
		return result;
	}
	
	@GetMapping("/selectByEmail")
	public String selectByEmail(@RequestParam("email") String email, Model model) {
		Optional<Member> result = mService.selectByEmail(email);
		if(result.isPresent()) {
			model.addAttribute("member",result.get()); //result.get() -> Optional 을 벗겨줌 (Member)
		}else {
			model.addAttribute("member",null); 
		}
		return "selectByEmail";
	}
	
	@GetMapping("/selectByNameLike")
	public List<Member> selectByNameLike(@RequestParam("username") String username, Model model) {
		username = "%"+username+"%";
		List<Member> result = mService.selectByUsernameLike(username);
		if(!(result.isEmpty())) {
			model.addAttribute("member",result);
		}else {
			model.addAttribute("member",null); 
		}
		return result;
	}
	
	@GetMapping("/selectByNameLikeDesc")
	public List<Member> selectByNameLikeDesc(@RequestParam("username") String username, Model model) {
		username = "%"+username+"%";
		List<Member> result = mService.selectByUsernameLikeDesc(username);
		if(!(result.isEmpty())) {
			model.addAttribute("member",result);
		}else {
			model.addAttribute("member",null); 
		}
		return result;
	}

	@GetMapping("/selectByNameLikeOrder")
	public List<Member> selectByNameLikeOrder(@RequestParam("username") String username, Model model) {
		username = "%"+username+"%";
		/*
		 * - Sort / Sort.Order
		 * - spring Framework 일부, 데이터 정렬을 지정하는데 사용 
		 * - Sort 클래스는 하나이상의 Sort.Order 객체를 가지고 있음 
		 * ex) 1개 일때
		 * 		Sort sort = Sort.by(Sort.Order("객체 빈 파일의 이름(컬럼명)"));
		 * 
		 * ex) 1개 이상 일때
		 * 		Sort sort = Sort.by(
		 * 			Sort.Order("컬럼명")
		 * 			Sort.Order("컬럼명")
		 * 			Sort.Order("컬럼명")
					...
		 *			 );
		 * */
		Sort sort = Sort.by(
				Sort.Order.desc("username"),
				Sort.Order.desc("email")
				);
		List<Member> result = mService.selectByUsernameLikeOrder(username, sort);
		if(!(result.isEmpty())) {
			model.addAttribute("member",result);
		}else {
			model.addAttribute("member",null); 
		}
		return result;
	}
	
}

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
	
	@GetMapping("/selectByNameLike")
	public String selectByNameLike(@RequestParam("name") String search,
										  @RequestParam("page") int page, 
										  Model model) {
		String name = "%"+search+"%";
		/*
		 * Pageable 인터페이스
		 * : Spring 에서는 Pagination을 지원하는 Pageable 인터페이스 제공
		 * - getPageNumber() : 현재 페이지 번호를 반환 (0부터 시작)
		 * - getPageSize() : 한 페이지당 최대 항목수를 반환
		 * - getOffset() : 현재 페이지의 시작 위치를 반환 
		 * - getSort() : 정렬 정보를 반환
		 * - next() : 다음페이지 정보를 반환
		 * - previous() : 이전페이지 정보를 반환
		 * 
		 *  PageRequest 클래스 
		 *  : Spring Date JPA 에서 제공하는 Pageable 구현체
		 *  - page : 조회할 페이지 번호(0부터 시작)
		 *  - size : 한페이지당 최대 항목수
		 *  - sort : 정렬정보(생략가능)
		 *  - direction : 정렬방향(ASC, DESC)
		 *  - properties : 정렬 대상 속성명
		 *  
		 *  > 생성자
		 *  PageRequest(int page, int size)
		 *  PageRequest(int page, int size, Sort sort)
		 *  PageRequest(int page, int size, Sort.Direction direction, String ...  properties)
		 *  
		 *  
		 * */
		int nPage = page-1;
		Sort sort = Sort.by(Sort.Order.desc("name"));
//		Pageable pagealbe = PageRequest.of(nPage,10);
		/*
		 * Pageable pagealbe = PageRequest.ofSize(10) 
										 * .withPage(nPage) 
										 * .withSort(sort);
		 */
		
		
		Pageable pageable = PageRequest.of(nPage,10,sort);
		Page<Member> result = mService.selectByNameLike(name, pageable);
		
		
		List<Member> content = result.getContent();
		long totalElement = result.getTotalElements(); // 총 레코드 수 
		int totalPages= result.getTotalPages(); // 총 페이지 수 
		int size = result.getSize(); // 1페이지당 들어갈 레코드 수 
		int pageNumber = result.getNumber()+1; // 현재 페이지 (0부터 시작)
		int numberOfElement = result.getNumberOfElements(); // 현재 페이지의 레코드
		
		model.addAttribute("member",content); // 실제 객체가 담긴 List<Memer> 을 반환 
		model.addAttribute("totalElement", totalElement);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("numberOfElement", numberOfElement);
		
		// 3주 3주 6주 -> 한달 , 한달 , 한달반?
		
		
		
		return "selectPage";
	}


	
}

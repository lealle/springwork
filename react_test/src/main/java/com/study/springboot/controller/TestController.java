package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Menu;
import com.study.springboot.service.MenuService;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Autowired
	MenuService mService;
	
	// @CrossOrigin(origins="http://localhost:3000") 저 위 맵핑안하면 일일히 이렇게 달아줘야함 
	@GetMapping("/test")
	public String Hello() {
		return "테스트 입니다.";
	}
	
	@GetMapping("/menuall")
	public List<Menu> menuAllList(){
		return mService.menuAllList();
	}
	
	@PostMapping("/addmenu")
	public Menu addMenu(@RequestBody Menu m) {
		return mService.insertMenu(m);
	}
	
}

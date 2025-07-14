package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.service.HomeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Homecontroller {
	
	private final HomeService homeservice;
	
	@GetMapping("/") // 전체리스트
	public String list(Model model, HttpServletRequest req) {
		return homeservice.list(model,req); // service 메소드 호출
	}
	@GetMapping("/detail")// 제목 클릭시 디테일 화면이동 
	public String detail(Model model, HttpServletRequest req) {
		return homeservice.detail(model,req);
	}
	@PostMapping("/edit")// 디테일에서 수정완료 정보이동
	public String edit(HttpServletRequest req) {
		return homeservice.edit(req);
	}
	

}

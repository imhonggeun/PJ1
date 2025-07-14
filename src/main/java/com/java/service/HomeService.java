package com.java.service;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

public interface HomeService {

	String list(Model model, HttpServletRequest req); // servicelmp 서비스 호출 전체 리스트

	String detail(Model model, HttpServletRequest req); // 제목 클릭시 디테일 화면이동

	String edit(HttpServletRequest req); // 디테일에서 수정완료 정보이동

	String input(HttpServletRequest req); // 글추가

	String accept(HttpServletRequest req); //승인,미승인 처리

}
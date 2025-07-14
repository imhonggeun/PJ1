package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.java.dao.HomeDao;
import com.java.dto.Ex1DTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HomeServiceImp implements HomeService{
	
	private final HomeDao homeDao;
	//private Ex1DTO u1;
	
	@Override // 전체리스트
	public String list(Model model, HttpServletRequest req) {
		String accept = req.getParameter("accept");
		if(accept == null) accept = "2";
		List<Ex1DTO> ex1s = homeDao.findList(accept);
		model.addAttribute("result", ex1s);
		return "list"; // list.html 호출
	}

	@Override // 제목 클릭시 디테일 화면이동
	public String detail(Model model, HttpServletRequest req) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			Ex1DTO ex1 = homeDao.findOne(no);
			model.addAttribute("result", ex1);
			return "detail"; // detail.html 호출
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "redirect:/"; //list 화면 이동
		}
	}

	@Override // 디테일에서 수정완료 정보이동
	public String edit(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return "redirect:/";
	}
	

}

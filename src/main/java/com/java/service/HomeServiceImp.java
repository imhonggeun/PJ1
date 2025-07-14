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
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Ex1DTO ex1DTO = Ex1DTO.builder().no(no).title(title).content(content).build();
			int status = homeDao.edit(ex1DTO);
			if (status == 1) return "redirect:/detail?no=" + no;			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@Override // 글추가
	public String input(HttpServletRequest req) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Ex1DTO ex1DTO = Ex1DTO.builder().title(title).content(content).build();
		homeDao.save(ex1DTO); 
			return "redirect:/";
		/*
		 * if(ex1DTO == null) { return "redirect:/"; } else { return
		 * "redirect:/detail?no=" + ex1DTO.getNo(); }
		 ex1DTO에 값이 null 이면 다시 list 로 넘어가고 만약 그렇지 않으면(값이 있다면 수정화면으로 이동-> 글추가 되었을때 전체리스트화면으로 이동으로변경*/ 
	}

	@Override
	public String accept(HttpServletRequest req) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			boolean accept = (req.getParameter("accept").equals("0")) ? true : false;
			Ex1DTO ex1DTO = Ex1DTO.builder().no(no).accept(accept).build();
			int status = homeDao.accept(ex1DTO);
			if(status ==1) return "redirect:/detail?no=" + no ;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	

}

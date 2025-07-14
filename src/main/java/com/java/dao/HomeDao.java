package com.java.dao;

import java.util.List;

import com.java.dto.Ex1DTO;

public interface HomeDao {

	public List<Ex1DTO> findList(String accept); //전체리스트

	public Ex1DTO findOne(int no); // 제목 클릭시 디테일 화면이동

	public int edit(Ex1DTO ex1dto); // 디테일에서 수정완료 정보이동

	public Ex1DTO save(Ex1DTO ex1DTO); // 글추가

	public int accept(Ex1DTO ex1dto); //

}

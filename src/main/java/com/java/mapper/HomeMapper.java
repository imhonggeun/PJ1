package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.java.dto.Ex1DTO;

@Mapper
public interface HomeMapper {
	
	@Select({"<script>"
			+ "SELECT no, title, content, accept, regDate FROM ex1 "
			+ "<if test='accept == 1'>WHERE accept = 1</if> "
			+ "<if test='accept == 0'>WHERE accept = 0</if> "
			+ "</script>"})
	public List<Ex1DTO> findList(String accept);

	@Select("select no, title, content, accept, regDate FROM ex1 Where No = #{No}")
	public Ex1DTO findOne(int no);

}

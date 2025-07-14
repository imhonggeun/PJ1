package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

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
	
	@Update("UPDATE ex1 SET title = #{title}, content = #{content} WHERE no = #{no}")
	public int edit(Ex1DTO ex1DTO);

	@SelectKey(statementType = StatementType.PREPARED, statement = "select last_insert_id() as no", keyProperty = "no", before = false, resultType = int.class)
	@Insert("INSERT INTO ex1 (title, content) VALUE (#{title}, #{content})")
	public int save(Ex1DTO ex1DTO);
	
	@Update("UPDATE ex1 SET accept = #{accept} WHERE no = #{no}")
	public int accept(Ex1DTO ex1DTO);

}

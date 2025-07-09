package com.example.PJ1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
	
	@Select("select * from movies")
	List<movie> movie();
}

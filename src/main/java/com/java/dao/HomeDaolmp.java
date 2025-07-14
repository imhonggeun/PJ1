package com.java.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.dto.Ex1DTO;
import com.java.mapper.HomeMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class HomeDaolmp implements HomeDao {
	
	private final HomeMapper homeMapper;
	
	@Override // 전체리스트 
	public List<Ex1DTO> findList(String accept) {
		return homeMapper.findList(accept);
	}

	@Override // 클릭스 화면이동
	public Ex1DTO findOne(int no) {
		return homeMapper.findOne(no);
	}

	@Override // 디테일에서 수정완료 정보이동
	public int edit(Ex1DTO ex1DTO) {
		return homeMapper.edit(ex1DTO);
	}

	@Override // 글추가
	public Ex1DTO save(Ex1DTO ex1DTO) {
		int status = homeMapper.save(ex1DTO);
		return (status ==1) ? ex1DTO :null;
	}

	@Override
	public int accept(Ex1DTO ex1DTO) {
		return homeMapper.accept(ex1DTO);
	}

}

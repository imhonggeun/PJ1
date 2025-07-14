package com.java.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ex1DTO {
	
	private int no;
	private String title;
	private String content;
	private boolean accept;
	private LocalDateTime regDate;
	
}

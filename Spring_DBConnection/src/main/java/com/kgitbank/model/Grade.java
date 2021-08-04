package com.kgitbank.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Grade {
	private Integer student_id;
	private String student_name;
	private Integer grade;
	
	
	@Override
	public String toString() {
		return "학번 : "+student_id+" 이름: "+student_name+" 성적: "+grade;
	}
}

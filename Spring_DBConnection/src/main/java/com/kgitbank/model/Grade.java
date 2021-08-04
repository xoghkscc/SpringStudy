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
		return "�й� : "+student_id+" �̸�: "+student_name+" ����: "+grade;
	}
}

package com.kgitbank.mapper;

import java.util.ArrayList;

import com.kgitbank.model.Grade;

public interface GradeMapper {
	
	public int insertGrade(Grade g);
	
	public Grade selectGrade(Grade g);
	
	public ArrayList<Grade> selectAllGrade();
	
	public int updateGrade(Grade g);
	
	public int deleteGrade(int student_id);
}

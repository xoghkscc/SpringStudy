package com.kgitbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.mapper.GradeMapper;
import com.kgitbank.model.Grade;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MenuServiceImpl implements MenuService{
	@Autowired
	GradeMapper gradeMapper;
	
	public boolean addNewGrade(Grade g) {
		System.out.println("올바른 이름이 있는지 체크하는 코드");
		System.out.println("올바른 성적의 형식인지 체크");
		System.out.println("널값 체크");
		
		log.info(gradeMapper);
		
		return true;
//		return gradeMapper.insertGrade(g)>0;
	}
}

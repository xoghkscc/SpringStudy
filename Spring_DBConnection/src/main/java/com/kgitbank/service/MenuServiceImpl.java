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
		System.out.println("�ùٸ� �̸��� �ִ��� üũ�ϴ� �ڵ�");
		System.out.println("�ùٸ� ������ �������� üũ");
		System.out.println("�ΰ� üũ");
		
		log.info(gradeMapper);
		
		return true;
//		return gradeMapper.insertGrade(g)>0;
	}
}

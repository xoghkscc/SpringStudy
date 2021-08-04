package com.kgitbank.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kgitbank.mapper.GradeMapper;
import com.kgitbank.model.Grade;

public interface MenuService {
	public boolean addNewGrade(Grade g);
}

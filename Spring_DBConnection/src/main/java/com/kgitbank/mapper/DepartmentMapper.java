package com.kgitbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Department;
import com.kgitbank.model.Employee;

public interface DepartmentMapper {
	@Select("SELECT * FROM departments")
	public List<Department> getDepartmentList();
	
	public Department getDepartment(int id);
}

package com.kgitbank.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Employee;

public interface EmployeeMapper {
	
	@Select("SELECT * FROM employees")
	public List<Employee> getEmpList();
	
	public Employee getEmployee(int id);
	
	public int create(Employee e);
	
	public ArrayList<Employee> getEmployeeGroup();
	
}

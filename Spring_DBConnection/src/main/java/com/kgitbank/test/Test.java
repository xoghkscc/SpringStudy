package com.kgitbank.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgitbank.mapper.DepartmentMapper;
import com.kgitbank.mapper.EmployeeMapper;
import com.kgitbank.model.Employee;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/test")
public class Test {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	
	@RequestMapping("/join")
	public String join() {
		return "test/join";
	}
	
	@RequestMapping("/employ1")
	public String test1(Model model, int id ) {
		Employee e1 = employeeMapper.getEmployee(id);
		log.info(e1);
		
		if(e1 != null) {
			model.addAttribute("employee1", e1);
			return "test/employ1";
		}else {
			return test2(model);
		}
	}
	
	@RequestMapping(value = "/employ2")
	public String test2(Model model) {
		model.addAttribute("employee2", employeeMapper.getEmployeeGroup());
		
		return "test/employ2";
	}
	
	@RequestMapping(value = "/department1")
	public String test3(Model model) {
		model.addAttribute("department1", departmentMapper.getDepartment(10));
		
		return "test/department1";
	}
}

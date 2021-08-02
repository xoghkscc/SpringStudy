package com.kgitbank.mapper;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgitbank.model.Department;
import com.kgitbank.model.Employee;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {
//	
//	@Autowired
//	private SqlSessionFactory sqlSessionFactory; 
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
//	@Autowired
//	private DepartmentMapper departmentMapper;
	
//	@Ignore
//	@Test
//	public void test() {
//		try (
//				SqlSession session = sqlSessionFactory.openSession();
//				Connection conn = session.getConnection();
//				){
//			log.info(conn);
//			assertNotNull(conn);
//		} catch (Exception e) {
//			fail(e.getMessage());
//		}
//		
//	}
	@Ignore
	@Test
	public void getListTest() {
		List<Employee> employees =  employeeMapper.getEmpList();
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}
	@Ignore
	@Test
	public void getTest() {
		Employee employee =  employeeMapper.getEmployee(122);
			System.out.println(employee);
	}
	@Ignore
	@Test
	public void createEmployee() {
		Employee e =  new Employee("Minsu2", "KMinsu2", new Date(), "IT_PROG");
		
		int row = employeeMapper.create(e);
		assertEquals(1, row);
	}
	
	@Test
	public void getListTest2() {
		ArrayList<Employee> employees =  employeeMapper.getEmployeeGroup();
		for(Employee employee : employees) {
			System.out.println(employee.getJob_id());
			System.out.println(employee.getSalary());
		}
	}

}

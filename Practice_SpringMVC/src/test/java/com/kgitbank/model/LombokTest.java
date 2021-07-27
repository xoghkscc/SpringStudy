package com.kgitbank.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

public class LombokTest {
	
	//이 클래스의 로깅을 담당하는 로커를 생성
	Logger log = Logger.getLogger(this.getClass());
	
	@Test
	public void test() {
		Employee emp = new Employee(10, "Smith", "Allen");
		
		log.fatal(emp);
		log.error(emp);
		log.warn(emp);
		log.info(emp);
		log.debug(emp);
		log.trace(emp);
		assertEquals("롬복 테스트 실패",1, emp.getDepartment_id());
	}

}

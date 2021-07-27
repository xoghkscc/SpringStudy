package com.kgitbank.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

public class LombokTest {
	
	//�� Ŭ������ �α��� ����ϴ� ��Ŀ�� ����
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
		assertEquals("�Һ� �׽�Ʈ ����",1, emp.getDepartment_id());
	}

}

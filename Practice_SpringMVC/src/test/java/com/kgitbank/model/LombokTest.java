package com.kgitbank.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LombokTest {

	
	@Test
	public void test() {
		Employee emp = new Employee(10, "Smith", "Allen");
		assertEquals("�Һ� �׽�Ʈ ����",1, emp.getDepartment_id());
	}

}

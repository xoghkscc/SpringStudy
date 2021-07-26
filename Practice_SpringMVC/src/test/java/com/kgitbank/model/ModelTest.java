package com.kgitbank.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelTest {
	
	@Autowired
	private Market market;
	
	@Test
	public void simpleTest() {
		int a = 10;
		int b = 20;
		
		assertEquals(30, a + b);//얘가 트루라고 하면 이 테스트 메서드는 통과되는 거임
	}
	
//	@Test //
//	public void di_test() {
//		
//	}
	
}

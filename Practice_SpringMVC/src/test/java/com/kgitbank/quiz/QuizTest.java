package com.kgitbank.quiz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class QuizTest {
	
	@Autowired
	Prime prime;
	
	//1�� �Ҽ��� �ƴ϶�� ������ ����ϴ� �׽�Ʈ�� �ۼ�
	@Test
	public void check1() {
		
		assertFalse("1�� �Ҽ��� �ƴ϶�� ���;� ��",prime.isPrime(1));
		//���
	}
	
	// 3�� �Ҽ���� �Ǻ��Ǹ� ����ϴ� �׽�Ʈ
	@Test
	public void check3() {
		assertTrue( "3�� �Ҽ����� �׽�Ʈ", prime.isPrime(3));
		//����
	}
	
	@Test(expected = CloneNotSupportedException.class)
	public void expectedTest() throws ClassNotFoundException {
		
		prime.veryAwesomeFunction(123);
	}
	
	@Test(timeout = 5000)//5��
	public void timeoutTest() {
		for(int i=0; i< 100000; i++) {
			System.out.println(i +"��° ���");
		}
	}
	
	
}






















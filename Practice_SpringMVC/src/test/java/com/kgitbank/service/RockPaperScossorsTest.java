package com.kgitbank.service;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.PostMapping;

import com.kgitbank.model.UserInfo;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class RockPaperScossorsTest {
	
	@Autowired
	private RockPaperScissors rps;
	
	
	@Test
	public void test() {
		for(int i = 0; i<20; i++) {
			log.error(rps.game());
		}
	}
	

}

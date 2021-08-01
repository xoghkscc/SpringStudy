package com.kgitbank.dbpractice;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBCTest {

	@Autowired
	HikariDataSource ds;

	@Test
	public void testGetConnection() {
		try (Connection conn = ds.getConnection();) {
			log.info(conn);
			assertNotNull(conn);

		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}

	@Test
	public void contextDataSourceTest() {
		try (Connection conn = ds.getConnection();) {
			log.info(conn);
			assertNotNull(conn);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}

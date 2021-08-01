package com.kgitbank.hikari;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCP_aws {
	HikariDataSource ds;

	public HikariCP_aws() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 서블릿에서 DB와 연동을 하려면 Class.forName이 필수이다!!
		} catch (Exception e) {
		}

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@3.35.52.40:1521:xe");//내 aws ec2 서버
//		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");// 내 로컬 서버
		config.setUsername("java1");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}

	public HikariDataSource getHikariDataSource() {
		return ds;
	}

}

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
			// �������� DB�� ������ �Ϸ��� Class.forName�� �ʼ��̴�!!
		} catch (Exception e) {
		}

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@3.35.52.40:1521:xe");//�� aws ec2 ����
//		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");// �� ���� ����
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

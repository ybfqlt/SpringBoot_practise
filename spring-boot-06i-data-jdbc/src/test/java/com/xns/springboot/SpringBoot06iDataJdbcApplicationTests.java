package com.xns.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot06iDataJdbcApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	public void contextLoads() throws SQLException {
		/**
		 * class com.zaxxer.hikari.HikariDataSource
		 */
		System.out.println(dataSource.getClass());

		Connection connection = dataSource.getConnection();
		/**
		 * HikariProxyConnection@557016605 wrapping com.mysql.cj.jdbc.ConnectionImpl@6c9320c2
		 */
		System.out.println(connection);
		connection.close();
	}

}

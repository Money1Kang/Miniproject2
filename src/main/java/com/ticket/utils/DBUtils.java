// DBUtils.java
package com.ticket.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//DB와 관련된 설정 정보나 수행들을 관리하는 클래스
public class DBUtils {

	// MySQL 서버 URL
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	
	// 사용하고자 하는 스키마(Database)이름
	private static final String DATABASE_NAME = "airplane";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	// Java와 MySQL Database를 연결
	public static Connection getConnection() throws SQLException {
//		Class.forName(DRIVER_NAME); // 과거의 사용 방식
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}


		
}
package com.multicampus.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			// 1. Driver Å¬·¡½º ·Îµù
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS·ÎºÎÅÍ Connection È¹µæ
			String url = "jdbc:oracle:thin:@localhost:1521:xe";			
			return DriverManager.getConnection(url, "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
		
		try {
			if(stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	public static void close(Statement stmt, Connection conn) {
		try {
			if(stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}








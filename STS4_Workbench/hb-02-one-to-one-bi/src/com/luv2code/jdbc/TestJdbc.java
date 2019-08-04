package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-02-one-to-one-bi?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to database : " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Successful !"  + myConn);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}

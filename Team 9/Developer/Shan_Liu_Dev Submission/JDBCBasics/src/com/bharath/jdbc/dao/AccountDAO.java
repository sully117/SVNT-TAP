package com.bharath.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
	
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","TEST1234567");
			System.out.println(connection);
			
			Statement stmt = connection.createStatement();
//			int result = stmt.executeUpdate("insert into account values(1, 'bao','bao', 10000)");
//			System.out.println(result + "got updated");
			
			
//			int result = stmt.executeUpdate("insert into account values(2, 'bao2','bao2', 2000)");
//			System.out.println(result + " got updated");
			
//			int res2 = stmt.executeUpdate("delete from account where accno = 2");
//			System.out.println(res2);
			
			ResultSet executeQuery = stmt.executeQuery("select * from account");
			while(executeQuery.next()) {
				String name = executeQuery.getString("lastname");
				System.out.println(name);
			}
			
			executeQuery.close(); // or just declaring these in try() parameters
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
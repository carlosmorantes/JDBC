package com.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoClient {

	public static void main(String[] args) throws SQLException {
		final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
		final String DB_URL = "jdbc:derby://localhost:1527/TestDB";
		
		final String USER = "APP";
		final String PASS = "APP";
		
		Connection connection = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			
			PreparedStatement st = connection.prepareStatement("insert into TABLE_EXAMPLE (ID, NAME, LOCATION, CAPACITY) values('99', 'mipredio', 'misala', 34)");
			
			st.executeUpdate();
			st.close();
			
		} catch (Exception e) {
			System.out.println("<Exception>: "+e.getMessage());
		}finally{
			if(!connection.isClosed()){
				connection.close();
				System.out.println("Connection was closed!");
			}
		}
			
		

	}

}

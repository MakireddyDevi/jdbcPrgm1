package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Sample {

	public static void main(String[] args) {
	 final String url="jdbc:mysql://localhost:3306/jdbcprgm1";
	 final String userName="root";
	 final String password="root123";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		}
		catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		try {
			Connection con=DriverManager.getConnection(url,userName,password);
			Statement stmt=con.createStatement();
			
		//	stmt.executeUpdate("insert into bankEmployee(id,name,salary,age) VALUES(1,'fayaz.sd',500000,29)");
			
			// stmt.executeUpdate("update bankEmployee set age='25' where id=3");
			
		//	stmt.executeUpdate("delete from bankEmployee where id=3");
			
			ResultSet rs = stmt.executeQuery("select * from bankEmployee");
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double salary = rs.getDouble(3);
				int age = rs.getInt(4);
				
				BankEmployee bankemp=new BankEmployee(id,name,salary,age);
				//System.out.println(id+" " + name+" " + salary+" "+age);
				System.out.println(bankemp);
			}
	
			
		}
	catch(SQLException e) {
		System.out.println(e.getMessage());
	}
		}
	
	

}

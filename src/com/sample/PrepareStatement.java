package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareStatement {

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
			//	PreparedStatement preparestmt = con.prepareStatement("insert into bankEmployee VALUES(? ,?, ?, ?)");
			//	PreparedStatement statement1 = con.prepareStatement("update bankEmployee set age=? where id=?");
				PreparedStatement statement2 = con.prepareStatement(" select * from bankEmployee");
//				preparestmt.setInt(1, 3);
//				preparestmt.setString(2, "mamatha");
//				preparestmt.setDouble(3, 250000);
//				preparestmt.setInt(4, 25);
//				
//				preparestmt.executeUpdate();
//			
//				statement1.setInt(1, 23);
//				statement1.setInt(2, 3);
//				statement1.executeUpdate();
				
				ResultSet query = statement2.executeQuery();
				while(query.next()) {
					
					int id = query.getInt(1);
					String name= query.getString(2);
					double salary = query.getDouble(3);
					int age = query.getInt(4);
					BankEmployee b1=new BankEmployee(id,name,salary,age);
					System.out.println(b1);
				}
				
			}
			
			catch(SQLException e) {
				System.out.println(e.getMessage());
				
			}
	}

}

package com.collabera.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class ConnectionManager 
{
	static final String URL = "jdbc:mysql://localhost:3306/testdb";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	public static Connection getConnection()
	{
		Connection conn = null;
		
		try 
		{
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection was made");
			
			Statement statement = conn.createStatement();
			
			boolean flag = statement.execute("select * from Jump_people");
			
			if (flag == false)
			{
				System.out.println("Here are the rows" + statement.getUpdateCount());
			}
			
			int count = statement.executeUpdate("Insert into Jump_people(firstname,lastname) values ('#######', '########')");
            System.out.println("Row Inserted and now the count is  " + count);
            
            //-----Update
            count = statement.executeUpdate("Update Jump_people set firstname = '######' where firstname = '######'");
            System.out.println("Row Updated and now the count is  " + count);
            
            //-----delete
            count = statement.executeUpdate("Delete from Jump_people where firstname = '#######'");
            System.out.println("Row deleted and now the count is  " + count);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) 
	{
		Connection conn = ConnectionManager.getConnection();
		
		// we did some stuff here
		
		try 
		{
			conn.close();
			System.out.println("Connection was closed");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

package com.collabera.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConfigurationFileEx 
{
	public static void main(String[] args) throws Exception 
	{
		FileInputStream file = new FileInputStream("C:\\Java_Workspace\\JDBCExample\\src\\com\\collabera\\jdbc\\world.prop");
		System.out.println("File found");
		
		Properties props = new Properties();
		props.load(file);
		String url = (String) props.get("url");
		String userName = (String) props.get("user");
		String password = (String) props.get("password");
		file.close();
		System.out.println("File closed");
		
		Connection conn = null;
		
		try
		{
			conn = DriverManager.getConnection(url, props); //you can use props or userName, password
			System.out.println("Connection made");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
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

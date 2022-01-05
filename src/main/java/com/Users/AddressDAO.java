package com.Users;
import java.sql.*;
import java.util.*;

import com.Users.AddressModel;

public class AddressDAO
{
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
	        Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public int registerAddr(AddressModel ad,int index)throws Exception
	{
		int idx = index;
		System.out.println(" IN ");
		int result = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			//Connection con = AddressDAO.getConnection();
			String INSERT_SQL = "INSERT INTO address(Line1, Line2, City, State, Country, Pincode) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setString(1, ad.getLine1(idx));
			ps.setString(2, ad.getLine2(idx));
			ps.setString(3, ad.getCity(idx));
			ps.setString(4, ad.getState(idx));
			ps.setString(5, ad.getCountry(idx));
			ps.setString(6, ad.getPin(idx));
			
			result = ps.executeUpdate();
			con.commit();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
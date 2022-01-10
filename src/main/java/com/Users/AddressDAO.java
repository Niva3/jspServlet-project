package com.Users;
import java.io.PrintStream;
import java.io.PrintWriter;
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
	
	public int registerAddr(AddressModel ad,int index,String user, PrintWriter out)throws Exception
	{
		int idx = index;
		
		out.println(" IN ");
		String line1=(ad.getLine1(idx)).toString();
		out.println("LINE1: "+line1);
		
		int result = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			//Connection con = AddressDAO.getConnection();
        	String SQL = "SELECT ID FROM users where Username='"+user+"'";
			String INSERT_SQL = "INSERT INTO address(UserID, Line1, Line2, City, State, Country, Pincode) VALUES (("+SQL+"),?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setString(1, (ad.getLine1(idx)).toString());
			ps.setString(2, (ad.getLine2(idx)).toString());
			ps.setString(3, (ad.getCity(idx)).toString());
			ps.setString(4, (ad.getState(idx)).toString());
			ps.setString(5, (ad.getCountry(idx)).toString());
			ps.setString(6, (ad.getPin(idx)).toString());
			
			result = ps.executeUpdate();
			con.commit();
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		return result;
	}
	
	public void getAddress(AddressModel adm,int id)throws Exception
	{
		try 
		{
			Connection con = AddressDAO.getConnection();
			String SQL = "SELECT * FROM address where userID ="+id;
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				adm.setLine1(rs.getString("Line1"));
				adm.setLine2(rs.getString("Line2"));
				adm.setCity(rs.getString("City"));
				adm.setState(rs.getString("State"));
				adm.setCountry(rs.getString("Country"));
				adm.setPin(rs.getString("Pincode"));
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<AddressModel> getAdd(AddressModel adm,int id)throws Exception
	{
		List<AddressModel> list = new ArrayList<AddressModel>();
		try 
		{
			Connection con = AddressDAO.getConnection();
			String SQL = "SELECT * FROM address where userID ="+id;
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				adm.setLine1(rs.getString("Line1"));
				adm.setLine2(rs.getString("Line2"));
				adm.setCity(rs.getString("City"));
				adm.setState(rs.getString("State"));
				adm.setCountry(rs.getString("Country"));
				adm.setPin(rs.getString("Pincode"));
				list.add(adm);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
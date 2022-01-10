package com.Users;
import com.Users.UserModel;

import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

public class UserDAO 
{
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
	        Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
    public int registerUser(UserModel user) throws Exception 
    {
    	System.out.println("function");
        int result = 0;
        try 
        {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
        	//Connection connection = UserDAO.getConnection();
        	String INSERT_USERS_SQL = "INSERT INTO users (Username, FirstName, LastName, Email, Gender, Languages, Contact, Password, Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getLanguages());
            preparedStatement.setString(7, user.getContact());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setString(9, user.getRole());
            
            result = preparedStatement.executeUpdate();
            connection.commit();
            connection.close();

        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
        return result;
    }
    
    public void loginUser(UserModel user,String uname)throws Exception
    {
    	try
    	{
            Connection conn = UserDAO.getConnection();
            Statement stmt = conn.createStatement();
            
        	String username=uname;
        	String SQL = "SELECT * FROM users where username='"+username+"'";
        	ResultSet rs = stmt.executeQuery(SQL);
        	
        	while(rs.next())
        	{
        		int id = rs.getInt("ID");
        		String firstname = rs.getString("FirstName");
        		String lastname = rs.getString("LastName");
        		String email = rs.getString("Email");
        		String gender = rs.getString("Gender");
        		String languages = rs.getString("Languages");
        		String contact = rs.getString("Contact");
        		String password = rs.getString("Password");
        		String role = rs.getString("Role");
        		
        		user.setID(id);
        		user.setFirstName(firstname);
        		user.setLastName(lastname);
        		user.setEmail(email);
        		user.setGender(gender);
        		user.setLanguages(languages);
        		user.setContact(contact);
        		user.setPassword(password);
        		user.setRole(role);
        	}
        	conn.close();	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public int editUser(UserModel user, int id)throws Exception
    {
    	int res=0;
    	try
    	{
    		Connection conn = UserDAO.getConnection();
    		String UPDATE_SQL = "UPDATE users SET FirstName=?, LastName=?, Username=?, Email=?, Gender=?, Languages=?, Contact=? where ID='"+id+"'";
    		PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
    		ps.setString(1, user.getFirstName());
    		ps.setString(2, user.getLastName());
    		ps.setString(3, user.getUsername());
    		ps.setString(4, user.getEmail());
    		ps.setString(5, user.getGender());
    		ps.setString(6, user.getLanguages());
    		ps.setString(7, user.getContact());
    		
    		res=ps.executeUpdate();
    		conn.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return res;
    }
    
    public int deleteUser(UserModel user, int id, PrintWriter out)throws Exception
    {
    	String temp = Integer.toString(id);
    	int res = 0;
		try
    	{
    		Connection conn = UserDAO.getConnection();
    		String DELETE_SQL = "DELETE FROM users where ID=?";
    		PreparedStatement st = conn.prepareStatement(DELETE_SQL);
    		st.setInt(1, user.getID());
    		res = st.executeUpdate();
    		conn.close();
    	}
    	catch(Exception e)
    	{
    		out.print(e);
    	}
    	return res;
    }
    
    public List<UserModel> getUsers()throws Exception
    {
    	List<UserModel> list = new ArrayList<UserModel>();
    	try
    	{
    		Connection con = UserDAO.getConnection();
    		PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS");
    		ResultSet rs=ps.executeQuery();
    		
    		while(rs.next())
    		{
    			UserModel rm = new UserModel();
    			rm.setID(rs.getInt("ID"));
    			rm.setFirstName(rs.getString("FirstName"));
    			rm.setLastName(rs.getString("LastName"));
    			rm.setUsername(rs.getString("Username"));
    			rm.setEmail(rs.getString("Email"));
    			rm.setPassword(rs.getString("Password"));
    			list.add(rm);
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
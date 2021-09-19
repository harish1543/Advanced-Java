package com.ltts.productionWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;

import com.ltts.productionWeb.Configuration.myConfig;
import com.ltts.productionWeb.model.*;

public class MemberDao {
	public boolean insertMember(Member m) throws Exception {
		System.out.println("Dao function call Success");
		Connection c = myConfig.getConnection();
		Statement s = c.createStatement();
		
		try {
			String insertQuery = "insert into member values('"+m.getName()+"','"+m.getEmail()+"','"+m.getMobile()+"','"+m.getLocation()+"','"+m.getPassword()+"')";
			s.execute(insertQuery);
		}catch(Exception e){
			
			System.out.println(e);
			return false;
		}finally{
			c.close();
		}	
		return true;
	}
	
	public boolean verifyLogin(String user, String pass) throws Exception {
		System.out.println("Dao function call Success");
		//List<Movie> li = new ArrayList<Movie>();
		Connection c = myConfig.getConnection();
		PreparedStatement ps = c.prepareStatement("select exists(select * from member where email=? and password =?)");
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		//System.out.println(res);
		rs.next();
		if(rs.getInt(1)==1)
		{
			return true;
		}
		
		return false;
		
	}

}

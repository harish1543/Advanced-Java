package com.ltts.productionWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
*/
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.ltts.productionWeb.model.Movie;
import com.ltts.productionWeb.Configuration.myConfig;
import com.ltts.productionWeb.model.Production;


public class ProductionDao {
	
	// insert new data entry in production table
	public boolean insertProduction2(Production p) throws Exception {
		System.out.println("Dao function call Success");
		Connection c = myConfig.getConnection();
		Statement s = c.createStatement();
		
		try {
			String insertQuery = "insert into production values("+p.getProductionId()+",'"+p.getProductionName()+"','"+p.getAddress()+"',"+p.getStartDate()+",'"+p.getOwnerName()+"')";
			s.execute(insertQuery);
		}catch(Exception e){
			
			System.out.println(e);
			return false;
		}finally{
			c.close();
		}	
		return true;
	}
	
	// display production table
	public List<Production> displayProduction() throws Exception{
		System.out.println("Dao function call Success");
		List<Production> li = new ArrayList<Production>();
		Connection c = myConfig.getConnection();
		PreparedStatement ps = c.prepareStatement("select * from production");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			li.add(new Production(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
		}
		
		return li;

	}
	// update production table
	public boolean updateProduction(Production p) throws Exception {
		System.out.println("Dao function call Success");
		Connection c = myConfig.getConnection();
		//Statement s = c.createStatement();
		
		try {
			String updateQuery = "update production set productionname=?, address = ?,dateofstarted = ?,ownername = ? where productionid = ?";
			PreparedStatement ps = c.prepareStatement(updateQuery);
			ps.setString(1, p.getProductionName());
			ps.setString(2, p.getAddress());
			ps.setInt(3, p.getStartDate());
			ps.setString(4, p.getOwnerName());
			ps.setInt(5, p.getProductionId());
			ps.executeUpdate();
			//s.execute(updateQuery);
			return true;
		}catch(Exception e){
			
			System.out.println(e);
			return false;
		}finally{
			c.close();
		}
	}
		
	
	//delete production
	public boolean deleteProduction(int Key) throws Exception{
		System.out.println("Dao function call Success");
		Connection c = myConfig.getConnection();
		PreparedStatement ps = c.prepareStatement("delete from production where productionid= ?");
		ps.setInt(1, Key);
		try {
			ps.executeUpdate();
			return true;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}



}
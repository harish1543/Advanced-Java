package com.ltts.productionWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ltts.productionWeb.Configuration.myConfig;
import com.ltts.productionWeb.model.Movie;

public class MovieDao {
	//display all movies
		public List<Movie> displayAllMovies() throws Exception{
			System.out.println("Dao function call Success");
			List<Movie> li = new ArrayList<Movie>();
			Connection c = myConfig.getConnection();
			PreparedStatement ps = c.prepareStatement("select * from movie");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				li.add(new Movie(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
			}
			
			return li;

		}
		
		//search Movies by language
		public List<Movie> displayMovie(String searchKey) throws Exception{
				System.out.println("Dao function call Success");
				List<Movie> li = new ArrayList<Movie>();
				Connection c = myConfig.getConnection();
				PreparedStatement ps = c.prepareStatement("select * from movie where language= ?");
				ps.setString(1, searchKey);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					li.add(new Movie(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
				}
				
				return li;
		
			}
		//delete movie
		public boolean deleteMovie(int Key) throws Exception{
			System.out.println("Dao function call Success");
			Connection c = myConfig.getConnection();
			PreparedStatement ps = c.prepareStatement("delete from movie where movieid= ?");
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

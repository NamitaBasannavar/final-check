package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.truyum.dao.ConnectionHandler;



public class MovieDaoSqlImpl implements MovieDao{

    

	@Override
	public List<Movie> getMovieListAdmin() {
		 Connection con = ConnectionHandler.getConnection();
         List<Movie> movieList = new ArrayList<>();
         try {
              String sql = "select * from movie_list";
              PreparedStatement ps = con.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();

              while (rs.next()) {
                   Movie movie = new Movie();
                   movie.setId(rs.getLong(1));
                   movie.setTitle(rs.getString(2));
                   movie.setBoxOffice(rs.getLong(3));
                   movie.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
                   movie.setDateofLaunch(rs.getDate(5));
                   movie.setGenre(rs.getString(6));
                   movie.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
                   movieList.add(movie);
              }

         } catch (Exception ex) {
              ex.printStackTrace();

         } finally {
              try {
                   con.close();
              } catch (Exception ex) {
                   ex.printStackTrace();
              }
         }
         return movieList;
   
	}
	
	@Override
	public List<Movie> getMovieListCustomer() {
		List<Movie> movieList =new ArrayList<>();
	    Connection con = ConnectionHandler.getConnection();
		try {
			String sql= "select * from movie_list WHERE me_active=? AND me_date_of_launch <=?"; 
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, "Yes");
			java.util.Date d=new java.util.Date();
			ps.setDate(2,new java.sql.Date(d.getTime()));
			
			ResultSet rs = ps .executeQuery();
			while(rs.next()) {
				 Movie movie = new Movie();
                 movie.setId(rs.getLong(1));
                 movie.setTitle(rs.getString(2));
                 movie.setBoxOffice(rs.getLong(3));
                 movie.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
                 movie.setDateofLaunch(rs.getDate(5));
                 movie.setGenre(rs.getString(6));
                 movie.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
                 movieList.add(movie);
				}

			} catch (Exception ex) {
				ex.printStackTrace();

			} finally {
				try {
			       con .close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}

			}
			return movieList;

		}
	
	@Override
	public void modifyMovie(Movie movie) {
		Connection con = ConnectionHandler.getConnection();
		
		String sql = "UPDATE movie_list SET me_title=? , me_boxoffice=?, me_active=?, me_date_of_launch=?,me_genre=?,me_hasteaser=? WHERE me_id=?";
		try {
			
		PreparedStatement ps = con.prepareStatement(sql);
	
		ps.setString(1, movie.getTitle());
		ps.setLong(2, movie.getBoxOffice());
		ps.setString(3, movie.isActive()?"Yes":"No");
		java.util.Date d=new java.util.Date();
		ps.setDate(4,new java.sql.Date(d.getTime()));
		ps.setString(5, movie.getGenre());
		ps.setString(6, movie.isHasTeaser()?"Yes":"No");
		ps.setLong(7, movie.getId());
		int result = ps.executeUpdate();
	
	} catch (Exception ex) {
		ex.printStackTrace();
	}finally {
		try {
		       con .close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}

		}


	}
	
		


	@Override
	public Movie getMovie(long MovieId) {
		Connection con = ConnectionHandler.getConnection();
		Movie movie = new Movie();
		try {
			String sql = "select * from movie_list where me_id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie movie1 = new Movie();
                movie1.setId(rs.getLong(1));
                movie1.setTitle(rs.getString(2));
                movie1.setBoxOffice(rs.getLong(3));
                movie1.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
                movie1.setDateofLaunch(rs.getDate(5));
                movie1.setGenre(rs.getString(6));
                movie1.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movie;
	}
	
}

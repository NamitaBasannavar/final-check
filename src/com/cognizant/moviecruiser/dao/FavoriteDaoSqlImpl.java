package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

import com.cognizant.truyum.dao.ConnectionHandler;

public class FavoriteDaoSqlImpl implements FavoriteDao {

	@Override
	public void addFavorite(long userId, long MovieId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "insert into favorite(ft_us_id,ft_pr_id)values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, MovieId);
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		 Connection con = ConnectionHandler.getConnection();
         List<Movie> favoriteList = new ArrayList<>();
        
         try {
                        
                         
        	 StringBuffer sqlBuffer = new StringBuffer();

 			sqlBuffer

 					.append("SELECT me_id,me_title, me_boxOffice,me_active, me_date_of_launch,me_genre,me_hasteaser FROM movie_list ")

 					.append("INNER JOIN favorite ON movie_list.me_id = favorite.ft_pr_id WHERE favorite.ft_us_id = ?");

 			PreparedStatement ps = con.prepareStatement(sqlBuffer.toString()); 
                         //PreparedStatement ps = con.prepareStatement(sqlBuffer);
                        
                         ps.setLong(1, userId);
                         ResultSet rs= ps.executeQuery();
                         while (rs.next()) {
                        	 Movie movie = new Movie();
                           
                             movie.setTitle(rs.getString(1));
                             movie.setBoxOffice(rs.getLong(2));
                             movie.setActive(rs.getString(3).equalsIgnoreCase("Yes"));
                             movie.setDateofLaunch(rs.getDate(4));
                             movie.setGenre(rs.getString(5));
                             movie.setHasTeaser(rs.getString(6).equalsIgnoreCase("Yes"));
                             movie.setId(rs.getLong(7));
                             favoriteList.add(movie);
                         }
         }catch (SQLException e) {
                         // TODO Auto-generated catch block
                        	 e.printStackTrace();
                         } finally {
                         try {
                                         con.close();
                         } catch (SQLException e) {

                                         e.printStackTrace();
                         }
         }
		return favoriteList;
        
	
	}

	@Override
	public void removeFavorite(long userId, long MovieId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = 
					"delete from favorite where ft_us_id=? and ft_pr_id=? limit 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, MovieId);
			int result = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
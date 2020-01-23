package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImplTest {
	 public static void main(String[] args) throws FavoriteEmptyException {
         testGetAllFavorite();
         testGetAddFavorite();
         testGetAllFavorite();
         testRemoveFavorite();
         testGetAllFavorite();
  }

  public static void testGetAddFavorite() throws FavoriteEmptyException {
         FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
         favoriteDao.addFavorite(1, 1);
         favoriteDao.addFavorite(1,4);
         try {
       	  List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
                System.out.println("User Added Favorite List for CheckOut");
                for (Movie movie : movieListCustomer) {
                      System.out.println(movie);
                }
         } catch (FavoriteEmptyException e) {
                System.out.println(e.getMessage());
         }
  }

  public static void testRemoveFavorite() throws FavoriteEmptyException {
         FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
         System.out.println("Movie List for Customer after Remove");
         try {
                favoriteDao.removeFavorite(1, 3L);
                favoriteDao.removeFavorite(1, 4L);
                List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
                for (Movie movie : movieListCustomer) {
                      System.out.println(movie);
                }
         } catch (FavoriteEmptyException e) {
                System.out.println(e.getMessage());
         }
  }

  public static void testGetAllFavorite() throws FavoriteEmptyException {
	  		FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
         try {
                List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
                System.out.println("Favorite movie list of user");
                for (Movie movie : movieListCustomer) {
                      System.out.println(movie);
                }
                System.out.println("No of favourites :" +movieListCustomer.size() +"\n");
         
         } catch (FavoriteEmptyException e) {
                System.out.println(e.getMessage());
         }
  }

}



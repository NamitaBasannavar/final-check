package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImplTest {

       public static void main(String[] args) throws FavoriteEmptyException {
              testGetAllFavorite();
              testGetAddFavorite();
              testGetAllFavorite();
              testRemoveFavorite();
              testGetAllFavorite();
       }

       public static void testGetAddFavorite() throws FavoriteEmptyException {
              FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
              favoriteDao.addFavorite(1, 3L);
              favoriteDao.addFavorite(1, 4L);
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
              FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
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
              FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
              try {
                     List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
                     System.out.println("Favorite movie list of user");
                     for (Movie movie : movieListCustomer) {
                           System.out.println(movie);
                     }
              } catch (FavoriteEmptyException e) {
                     System.out.println(e.getMessage());
              }
       }

}


package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public class FavoritesDaoCollectionImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
		testGetAllFavorites();
		testGetAddFavorites();
		testRemoveFavorite();
	}

	public static void testGetAddFavorites() throws FavoriteEmptyException {
		FavoriteDao favoritesDao = new FavoriteDaoCollectionImpl();

		favoritesDao.addFavoriteItem(1, 3L);
		favoritesDao.addFavoriteItem(1, 4L);

		List<MovieItem> movieListCustomer = favoritesDao.getAllFavoriteItems(1);
		System.out.println("User Added Favorite List for CheckOut");
		for (MovieItem movie : movieListCustomer) {
			System.out.println(movie);
		}
	}

	public static void testGetAllFavorites() throws FavoriteEmptyException {
		try {
		FavoriteDao favoritesDao = new FavoriteDaoCollectionImpl();
		
			List<MovieItem> movieListCustomer = favoritesDao.getAllFavoriteItems(1);
			System.out.println("Favorite Movies List Of User");

			for (MovieItem movie : movieListCustomer) {

				System.out.println(movie);
			}
		} catch (FavoriteEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testRemoveFavorite() throws FavoriteEmptyException {
		FavoriteDao favoritesDao = new FavoriteDaoCollectionImpl();
		System.out.println("Customer Movie List for after Remove");
		try {
			favoritesDao.removeFavoriteItem(1, 3L);
			favoritesDao.removeFavoriteItem(1, 4L);

			List<MovieItem> movieListCustomer = favoritesDao.getAllFavoriteItems(1);
			for (MovieItem movie : movieListCustomer) {
				System.out.println(movie);
			}
		} catch (FavoriteEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}

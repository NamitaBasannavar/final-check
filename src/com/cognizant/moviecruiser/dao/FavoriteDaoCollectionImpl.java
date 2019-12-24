package com.cognizant.moviecruiser.dao;

import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieItem;

public class FavoriteDaoCollectionImpl implements FavoriteDao {

	private static HashMap<Long, Favorites> userFavorites;
	private double total;

	public FavoriteDaoCollectionImpl() {

		if (userFavorites == null) {
			userFavorites = new HashMap<>();
			userFavorites.put(1l, new Favorites());
		}

	}

	public void addFavoriteItem(long userId, long movieItemId) {
		try {
			MovieDao movieItemDao = new MovieDaoCollectionImpl();
			MovieItem movieItem = movieItemDao.getMovieItem(movieItemId);
			if (userFavorites.containsKey(userId)) {
				
				Favorites favorite = userFavorites.get(userId);
				favorite.getMovieItemList().add(movieItem);
			} else {
				Favorites favorite = new Favorites();
				favorite.getMovieItemList().add(movieItem);
				userFavorites.put(userId, favorite);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<MovieItem> getAllFavoriteItems(long userId) throws FavoriteEmptyException {
		List<MovieItem> movieItemList = userFavorites.get(userId).getMovieItemList();
		
		
		Favorites favorites = userFavorites.get(userId);
		double total = 0.0;
		if (favorites == null ||favorites.getMovieItemList() == null ||movieItemList.isEmpty()) {
			throw new FavoriteEmptyException();
		} else {
			for (MovieItem movieItem : movieItemList) {
				total += movieItem.getBoxoffice();

			}
		}
		return movieItemList;

	}

	@Override
	public void removeFavoriteItem(long userId, long movieItemId) {
		List<MovieItem> movieItemList = userFavorites.get(userId).getMovieItemList();
		for (int i = 0; i < movieItemList.size(); i++) {
			if (movieItemList.get(i).getId() == movieItemId) {
				movieItemList.remove(i);
				break;
			}

		}

	}

	


}
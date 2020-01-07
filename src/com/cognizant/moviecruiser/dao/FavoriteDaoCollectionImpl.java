package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, Favorite> userFavorite;

	public FavoriteDaoCollectionImpl() {
		if (userFavorite == null) {
			userFavorite = new HashMap<>();
			userFavorite.put(1L, new Favorite());

		}
	}

	@Override
	public void addFavorite(long userId, long movieId) {
		try {
			MovieDao movieDao = new MovieDaoCollectionImpl();
			Movie movie = movieDao.getMovie(movieId);

			if (userFavorite.containsKey(userId)) {
				Favorite favorite = userFavorite.get(userId);
				favorite.getMovieList().add(movie);
			} else {
				Favorite favorite = new Favorite();
				favorite.getMovieList().add(movie);
				userFavorite.put(userId, favorite);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		Favorite favorite = userFavorite.get(userId);

		if (favorite == null || favorite.getMovieList() == null || favorite.getMovieList().isEmpty()) {
			throw new FavoriteEmptyException();
		}
		List<Movie> movieList = userFavorite.get(userId).getMovieList();
		return movieList;
	}

	@Override
	public void removeFavorite(long userId, long MovieId) throws FavoriteEmptyException {
		Favorite favorite = userFavorite.get(userId);
		if (favorite != null && !favorite.getMovieList().isEmpty()) {
			for (int i = 0; i < favorite.getMovieList().size(); i++) {
				if (favorite.getMovieList().get(i).getId() == MovieId) {
					favorite.getMovieList().remove(i);
					break;
				}

			}
		} else {
			throw new FavoriteEmptyException("No Favorite");
		}
	}
}

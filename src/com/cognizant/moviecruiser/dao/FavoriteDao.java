package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface FavoriteDao {

	public void addFavoriteItem(long userId, long movieItemId);

	public List<MovieItem> getAllFavoriteItems(long userId) throws FavoriteEmptyException;

	public void removeFavoriteItem(long userId, long movieItemId);

	

}
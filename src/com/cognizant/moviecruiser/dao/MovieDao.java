package com.cognizant.moviecruiser.dao;

import java.awt.MenuItem;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface MovieDao {
	public List<MovieItem> getMovieItemListAdmin();

	public List<MovieItem> getMovieItemListCustomer();

	public void modifyMovieItem(MovieItem MovieItem);

	public MovieItem getMovieItem(long movieItemId);

}

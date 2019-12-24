package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteEmptyException;
import com.cognizant.moviecruiser.dao.MovieDao;

public class Favorites{

	private List<MovieItem> movieItemList;
	private double noOfFavorites1;
	public Favorites(List<MovieItem> movieItemList, double noOfFavorites1) {
		super();
		this.movieItemList = movieItemList;
		this.noOfFavorites1 = noOfFavorites1;
	}
	public Favorites() {
		super();
		movieItemList= new ArrayList<>();
	}
	public List<MovieItem> getMovieItemList() {
		return movieItemList;
	}
	public void setMovieItemList(List<MovieItem> movieItemList) {
		this.movieItemList = movieItemList;
	}
	public double getNoOfFavorites1() {
		return noOfFavorites1;
	}
	public void setNoOfFavorites1(double noOfFavorites1) {
		this.noOfFavorites1 = noOfFavorites1;
	}

	

	
}

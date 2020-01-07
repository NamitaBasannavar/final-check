package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.dao.MovieDao;

public class Favorite {
	private List<Movie> movieList;

	public Favorite(List<Movie> movieList) {
		super();
		this.movieList = movieList;
	}

	public Favorite() {
		super();
		movieList = new ArrayList<>();
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

}

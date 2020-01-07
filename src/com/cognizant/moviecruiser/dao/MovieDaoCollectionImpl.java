package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movie;
	public List<Movie> getmovieListCustomer;

	public MovieDaoCollectionImpl() throws ParseException {
		super();
		if (movie == null) {
			movie = new ArrayList();
			movie.add(new Movie(1, "Avatar", 2787965087l, true, DateUtil.convertToDate("15/03/2017"), "Science Fiction",
					true));
			movie.add(new Movie(2, "The Avengers", 1518812988, true, DateUtil.convertToDate("23/12/2017"), "Superhero",
					false));
			movie.add(
					new Movie(3, "Titanic", 2187463944l, true, DateUtil.convertToDate("21/08/2017"), "Romance", false));
			movie.add(new Movie(4, "Jurassic World", 1671713208, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			movie.add(
					new Movie(5, "Avatar", 2750760348l, true, DateUtil.convertToDate("02/11/2022"), "Superhero", true));

		}
	}

	@Override
	public List<Movie> getMovieListAdmin() {

		return movie;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		List<Movie> customerList = new ArrayList<>();
		Date today = new Date();
		for (Movie x : movie) {
			if (x.isActive() && x.getDateofLaunch().before(today)) {
				customerList.add(x);
			}
		}

		return customerList;

	}

	@Override
	public void modifyMovie(Movie movie) {
		Movie x = getMovie(movie.getId());
		x.setTitle(movie.getTitle());
		x.setBoxOffice(movie.getBoxOffice());
		x.setActive(true);
		x.setDateofLaunch(movie.getDateofLaunch());
		x.setGenre(movie.getGenre());
		x.setHasTeaser(true);
	}

	@Override
	public Movie getMovie(long MovieId) {
		Movie m = null;
		for (Movie x : movie) {
			if (x.getId() == MovieId) {
				m = x;
				break;
			}
		}
		return m;
	}

}

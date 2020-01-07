package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

import java.text.ParseException;

public class MovieDaoCollectionImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("----------Admin List-----------");
			System.out.println("Admin movie list ");
			testGetMovieAdmin();
			System.out.println("----------Customer List-----------");
			System.out.println("Customer movie list ");
			testGetMovieCustomer();
			testModifyMovie();
			System.out.println("----------modified List-----------");
			System.out.println("Modify movie list ");

		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public static void testGetMovieAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {

			System.out.println(x);
		}
	}

	public static void testGetMovieCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListCustomer();
		for (Movie x : movieList) {

			System.out.println(x);
		}
	}

	public static void testModifyMovie() throws ParseException {
		Movie m = new Movie(4, "Jurassic World", 1671713208l, false, DateUtil.convertToDate("02/07/2017"),
				"Science Fiction", true);
		MovieDao movieDao = new MovieDaoCollectionImpl();
		movieDao.modifyMovie(m);
	}

}

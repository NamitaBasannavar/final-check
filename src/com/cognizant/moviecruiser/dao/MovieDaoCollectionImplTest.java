package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException {
		System.out.println("===============Admin Movie List==============");
		testGetMovieListAdmin();
		System.out.println("===============Customer Movie List==============");
		testGetMovieListCustomer();
		System.out.println("===============Modified Movie List==============");
		testModifyMovie();
		testGetMovieListAdmin();
	}

	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();

		List<MovieItem> movieList = movieDao.getMovieItemListAdmin();
		for (MovieItem x : movieList) {

			System.out.println(x);
		}
	}

	public static void testGetMovieListCustomer() throws ParseException {

		MovieDao movieDao = new MovieDaoCollectionImpl();

		List<MovieItem> customerList = movieDao.getMovieItemListCustomer();
		for (MovieItem x : customerList) {

			System.out.println(x);
		}
	}

	private static void testModifyMovie() throws ParseException {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		MovieItem movie = new MovieItem(1, "KGF", 2787965087l, true, DateUtil.convertToDate("15/03/2017"),
				"Science Fiction", true);

		movieDao.modifyMovieItem(movie);
	}
}

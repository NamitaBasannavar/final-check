package com.cognizant.moviecruiser.dao;

import java.awt.MenuItem;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {

	private static List<MovieItem> movieItemList;

	public MovieDaoCollectionImpl() throws ParseException {
		super();
		if (movieItemList == null) {
			movieItemList = new ArrayList<>();
			movieItemList.add(new MovieItem(1, "Avatar", 2787965087l, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieItemList.add(new MovieItem(2, "The Avenger", 1518812988, false, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			movieItemList.add(new MovieItem(3, "Titanic", 2187463944L, false, DateUtil.convertToDate("21/08/2017"),
					"Romance", false));
			movieItemList.add(new MovieItem(4, "Jurassic World", 1671713208, false,
					DateUtil.convertToDate("02/07/2017"), "Science Fiction", true));
			movieItemList.add(new MovieItem(5, "Avengers End Game", 2750760348L, true,
					DateUtil.convertToDate("02/11/2022"), "Superhero", true));

		}

	}

	@Override
	public List<MovieItem> getMovieItemListAdmin() {
		return movieItemList;
	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		List<MovieItem> customerList = new ArrayList<>();
		Date today = new Date();
		for (MovieItem x : movieItemList) {
			if (x.isActive() && x.getDateOfLaunch().before(today)) {
				customerList.add(x);
			}
		}

		return customerList;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		MovieItem x = getMovieItem(movieItem.getId());
		x.setTitle(movieItem.getTitle());
		x.setBoxoffice(movieItem.getBoxoffice());
		x.setDateOfLaunch(movieItem.getDateOfLaunch());
		x.setGenre(movieItem.getGenre());
		x.setHasTeaser(movieItem.isHasTeaser());

	}

	@Override
	public MovieItem getMovieItem(long movieItemId) {
		MovieItem s = null;
		for (MovieItem x : movieItemList) {
			if (x.getId() == movieItemId) {
				s = x;
				break;
			}
		}
		return s;

	}
}

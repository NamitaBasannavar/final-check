		package com.cognizant.moviecruiser.dao;
		
		import java.util.List;
		
		import com.cognizant.moviecruiser.model.Movie;
		import com.cognizant.moviecruiser.util.DateUtil;
		
		import java.text.ParseException;
		
		public class MovieDaoSqlImplTest {
		
			public static void main(String[] args) {
				try {
					System.out.println("----------Admin List-----------");
					System.out.println("Admin movie list ");
					testGetMovieAdmin();
					System.out.println("----------Customer List-----------");
					System.out.println("Customer movie list ");
					testGetMovieCustomer();
					
					System.out.println("----------modified List-----------");
					testModifyMovie();
					testGetMovieAdmin();
				} catch (ParseException e) {
					System.out.println(e);
				}
			}
		
			public static void testGetMovieAdmin() throws ParseException {
				MovieDao movieDao = new MovieDaoSqlImpl();
				List<Movie> movieList = movieDao.getMovieListAdmin();
				for (Movie x : movieList) {
		
					System.out.println(x);
				}
			}
		
			public static void testGetMovieCustomer() throws ParseException {
				MovieDao movieDao = new MovieDaoSqlImpl();
				List<Movie> movieList = movieDao.getMovieListCustomer();
				for (Movie x : movieList) {
		
					System.out.println(x);
				}
			}
		
			public static void testModifyMovie() throws ParseException {
				Movie m = new Movie(4, "Kgf", 1671713208l, false, DateUtil.convertToDate("02/07/2017"),
						"Science Fiction", true);
				MovieDao movieDao = new MovieDaoSqlImpl();
				movieDao.modifyMovie(m);
			}
		
		}

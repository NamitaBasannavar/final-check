package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieItemServlet
 */
@WebServlet({ "/EditMovieItemServlet", "/EditMovieItem" })
public class EditMovieItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("movieId"));
			String title = request.getParameter("texttitle");
			long boxOffice = Long.parseLong(request.getParameter("textboxOffice"));
			boolean active = Boolean.parseBoolean(request.getParameter("active"));
			Date dateofLaunch = DateUtil.convertToDate(request.getParameter("textdateofLaunch"));
			String genre = request.getParameter("genre");
			boolean hasTeaser = Boolean.parseBoolean(request.getParameter("hasTeaser"));

			Movie movie = new Movie(id, title, boxOffice, active, dateofLaunch, genre, hasTeaser);

			MovieDao movieDao = new MovieDaoCollectionImpl();

			movieDao.modifyMovie(movie);
			request.setAttribute("msg", "Movie edited successfully ");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

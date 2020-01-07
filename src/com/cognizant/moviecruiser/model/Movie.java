package com.cognizant.moviecruiser.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
	private long id;
	private String title;
	private long boxOffice;
	private boolean active;
	private Date dateofLaunch;
	private String genre;
	private boolean hasTeaser;

	public Movie(long id, String title, long boxOffice, boolean active, Date dateofLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateofLaunch = dateofLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(long boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateofLaunch() {
		return dateofLaunch;
	}

	public void setDateofLaunch(Date dateofLaunch) {
		this.dateofLaunch = dateofLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat box = NumberFormat.getInstance();
		String details = String.format("%-15s $.%10s %-10s %-15s %-15s %-10s", title, box.format(boxOffice),
				active ? "Yes" : "No", sdf.format(dateofLaunch), genre, hasTeaser ? "Yes" : "No");
		return details;
	}

}

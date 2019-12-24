package com.cognizant.moviecruiser.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItem {
	private static final String sdf = null;
	private long id;
	private String Title;
	private long Boxoffice;
	private boolean Active;
	private Date dateOfLaunch;
	private String Genre;
	private boolean HasTeaser;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public long getBoxoffice() {
		return Boxoffice;
	}

	public void setBoxoffice(long boxoffice) {
		Boxoffice = boxoffice;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public boolean isHasTeaser() {
		return HasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		HasTeaser = hasTeaser;
	}

	public MovieItem(long id, String title, long boxoffice, boolean active, Date dateOfLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.id=id;
		Title = title;
		Boxoffice = boxoffice;
		Active = active;
		this.dateOfLaunch = dateOfLaunch;
		Genre = genre;
		HasTeaser = hasTeaser;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat box=NumberFormat.getInstance();
		String details = String.format("%-15s $.%10d %-10s %-10s %-15s %-15s", Title, Boxoffice, Active ?"Yes" : "No",  sdf.format(dateOfLaunch),
				Genre, HasTeaser);
		return details;

	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public MovieItem getMovieItem(long movieItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getGross() {
		// TODO Auto-generated method stub
		return 0;
	}

}

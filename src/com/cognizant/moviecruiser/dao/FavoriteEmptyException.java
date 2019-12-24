package com.cognizant.moviecruiser.dao;

public class FavoriteEmptyException extends Exception {
	public FavoriteEmptyException() {
		super("Favorite is empty");
	}

	public FavoriteEmptyException(String message) {
		super(message);
	}

}

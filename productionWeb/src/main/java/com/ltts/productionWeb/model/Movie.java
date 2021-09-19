package com.ltts.productionWeb.model;

import java.util.Date;

//import java.time.LocalDate;
//import java.util.Date;

public class Movie {
	
	private int movieId;
	private String movieName;
	private String heroname;
	private String heroineName;
	private Date releaseDate;
	private String language;
	private int length;
	private String movieType;
	private int productionId;
	public Movie() {
		super();
	}
	public Movie(int movieId, String movieName, String heroname, String heroineName, Date releaseDate,
			String language, int length, String movieType, int productionId) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.heroname = heroname;
		this.heroineName = heroineName;
		this.releaseDate = releaseDate;
		this.language = language;
		this.length = length;
		this.movieType = movieType;
		this.productionId = productionId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getHeroname() {
		return heroname;
	}
	public void setHeroname(String heroname) {
		this.heroname = heroname;
	}
	public String getHeroineName() {
		return heroineName;
	}
	public void setHeroineName(String heroineName) {
		this.heroineName = heroineName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public int getProductionId() {
		return productionId;
	}
	public void setProductionId(int productionId) {
		this.productionId = productionId;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", heroname=" + heroname + ", heroineName="
				+ heroineName + ", releaseDate=" + releaseDate + ", language=" + language + ", length=" + length
				+ ", movieType=" + movieType + ", productionId=" + productionId + "]";
	}
	
	

}
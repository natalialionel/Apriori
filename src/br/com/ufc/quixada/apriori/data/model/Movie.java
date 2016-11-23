package br.com.ufc.quixada.apriori.data.model;

import java.util.List;

public class Movie {
	private String movieId;
	private String title;
	private List<String> listGenres;
	private List<String> listDirectors;
	private Double averageCriticRating;
	private Integer numberCriticRatings;
	private String birthyear;
	private String gender;
	private Double convertedRating;
	private FrequentItem frequentItem;
	
	public Movie() {
		this.movieId = "";
		this.title = "";
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getListGenres() {
		return listGenres;
	}

	public void setListGenres(List<String> listGenres) {
		this.listGenres = listGenres;
	}

	public List<String> getListDirectors() {
		return listDirectors;
	}

	public void setListDirectors(List<String> listDirectors) {
		this.listDirectors = listDirectors;
	}

	public Double getAverageCriticRating() {
		return averageCriticRating;
	}

	public void setAverageCriticRating(Double averageCriticRating) {
		this.averageCriticRating = averageCriticRating;
	}

	public Integer getNumberCriticRatings() {
		return numberCriticRatings;
	}

	public void setNumberCriticRatings(Integer numberCriticRatings) {
		this.numberCriticRatings = numberCriticRatings;
	}

	public String getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getConvertedRating() {
		return convertedRating;
	}

	public void setConvertedRating(Double convertedRating) {
		this.convertedRating = convertedRating;
	}

	public FrequentItem getFrequentItem() {
		return frequentItem;
	}

	public void setFrequentItem(FrequentItem frequentItem) {
		this.frequentItem = frequentItem;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", listGenres=" + listGenres + ", listDirectors="
				+ listDirectors + ", averageCriticRating=" + averageCriticRating + ", numberCriticRatings="
				+ numberCriticRatings + ", birthyear=" + birthyear + ", gender=" + gender + ", convertedRating="
				+ convertedRating + ", frequentItem=" + frequentItem + "]";
	}
	
}

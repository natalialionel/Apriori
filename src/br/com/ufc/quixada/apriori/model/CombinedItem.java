package br.com.ufc.quixada.apriori.model;

public class CombinedItem {
	
	private FrequentItem birthyear;
	private FrequentItem gender;
	private FrequentItem genres;
	public int getFrequenceCombined() {
		return frequenceCombined;
	}

	public void setFrequenceCombined(int frequenceCombined) {
		this.frequenceCombined = frequenceCombined;
	}

	private int frequenceCombined;
	
	
	
	public CombinedItem(FrequentItem birthyear, FrequentItem gender, FrequentItem genres) {	
		this.birthyear = birthyear;
		this.gender = gender;
		this.genres = genres;
	}

	public CombinedItem() {	
		this.birthyear = null;
		this.gender = null;
		this.genres = null;
	}

	public FrequentItem getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(FrequentItem birthyear) {
		this.birthyear = birthyear;
	}

	public FrequentItem getGender() {
		return gender;
	}

	public void setGender(FrequentItem gender) {
		this.gender = gender;
	}

	public FrequentItem getGenres() {
		return genres;
	}

	public void setGenres(FrequentItem genres) {
		this.genres = genres;
	}
	
	@Override
	public String toString() {
		return "CombinedItem [birthyear=" + birthyear.getItem() + ", gender=" + gender.getItem() + ", genres=" + genres.getItem()
				+ ", frequenceCombined=" + frequenceCombined + "]";
	}
	
}

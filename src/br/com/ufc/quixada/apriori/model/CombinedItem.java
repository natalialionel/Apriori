package br.com.ufc.quixada.apriori.model;

public class CombinedItem {
	
	private FrequentItem birthyear;
	private FrequentItem gender;
	private FrequentItem genres;
	private FrequentItem title;
	private double frequenceCombined;
	private double confianceCombined;
	

	
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
	
	public Double getFrequenceCombined() {
		return frequenceCombined;
	}

	public void setFrequenceCombined(Double frequenceCombined) {
		this.frequenceCombined = frequenceCombined;
	}
	
	public Double getConfianceCombined() {
		return confianceCombined;
	}

	public void setConfianceCombined(Double confianceCombined) {
		this.confianceCombined = confianceCombined;
	}
	
	public FrequentItem getTitle() {
		return title;
	}

	public void setTitle(FrequentItem title) {
		this.title = title;
	}

	public String print() {
		return "CombinedItem [birthyear=" + birthyear.getItem() + ", gender=" + gender.getItem()
				+ ", frequenceCombined=" + frequenceCombined + ", confianceCombined="+confianceCombined +"]";
	}

	@Override
	public String toString() {
		return "CombinedItem [birthyear=" + birthyear + ", gender=" + gender + ", genres=" + genres + ", title=" + title
				+ ", frequenceCombined=" + frequenceCombined + ", confianceCombined=" + confianceCombined + "]";
	}
		
	
}

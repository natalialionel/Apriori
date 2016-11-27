package br.com.ufc.quixada.apriori.model;

public class Transaction {
	
	private Integer transactionId;
	private Movie movie;
	private boolean added;
	private boolean addedBirthday;
	private boolean addedGender;
	private boolean addedListGenres;
	
	public Transaction() {
		this.transactionId = 0;
		this.movie = new Movie();
		this.added = false;
		this.addedBirthday = false;
		this.addedGender = false;
		this.addedListGenres = false;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

	public boolean isAddedBirthday() {
		return addedBirthday;
	}

	public void setAddedBirthday(boolean addedBirthday) {
		this.addedBirthday = addedBirthday;
	}

	public boolean isAddedGender() {
		return addedGender;
	}

	public void setAddedGender(boolean addedGender) {
		this.addedGender = addedGender;
	}

	public boolean isAddedListGenres() {
		return addedListGenres;
	}

	public void setAddedListGenres(boolean addedListGenres) {
		this.addedListGenres = addedListGenres;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", movie=" + movie + ", added=" + added
				+ ", addedBirthday=" + addedBirthday + ", addedGender=" + addedGender + ", addedListGenres="
				+ addedListGenres + "]";
	}

	
	

}

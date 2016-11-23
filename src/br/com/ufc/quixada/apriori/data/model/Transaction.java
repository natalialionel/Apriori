package br.com.ufc.quixada.apriori.data.model;

public class Transaction {
	
	private Integer transactionId;
	private Movie movie;
	private boolean added;
	
	public Transaction() {
		this.transactionId = 0;
		this.movie = new Movie();
		this.added = false;  
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

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", movie=" + movie + ", added=" + added + "]";
	}

	
	

}

package br.com.ufc.quixada.apriori.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ufc.quixada.apriori.constants.Constants;
import br.com.ufc.quixada.apriori.model.FrequentItem;
import br.com.ufc.quixada.apriori.model.Movie;
import br.com.ufc.quixada.apriori.model.Transaction;

public class Prune {
	
	private List<FrequentItem> listfrequentBirthyear = new ArrayList<FrequentItem>();
	private List<FrequentItem> listfrequentGender = new ArrayList<FrequentItem>();
	private List<FrequentItem> listfrequentGenres = new ArrayList<FrequentItem>();
	
	private static FrequentItem itemBirthday = null;
	private static FrequentItem itemGender = null;
	private static FrequentItem itemListGenres = null;
	
	private GenerateCandidate generateCandidate;
	private Transaction transaction;
	private List<Transaction> listTransaction;
	
	public Prune(){
		this.generateCandidate = new GenerateCandidate();
		this.transaction = new Transaction();
	}
	
	public Map<String, List<FrequentItem>> generateCandidates(List<Movie> movies, Double minsuport){
		
		Map<String, List<FrequentItem>> hm = new HashMap<String, List<FrequentItem>>();
		listTransaction = getTransactions(movies);
		
		for (Movie movie : movies) {
			
			List<FrequentItem> resultList = generateCandidate.itemFrequences(listTransaction, minsuport, movie);
			
			itemBirthday = resultList.get(Constants.ATTR_BIRTHYEAR);
			itemGender = resultList.get(Constants.ATTR_GENDER);
			itemListGenres = resultList.get(Constants.ATTR_GENRES);


			if (itemBirthday != null) {
				itemBirthday.setFrequence(itemBirthday.getFrequence());
				itemBirthday.setItem(movie.getBirthyear());
				listfrequentBirthyear.add(itemBirthday);
			}

			if (itemGender != null) {
				itemGender.setFrequence(itemGender.getFrequence());
				itemGender.setItem(movie.getGender());
				listfrequentGender.add(itemGender);
			}

			if (itemListGenres != null) {
				itemListGenres.setFrequence(itemListGenres.getFrequence());
				itemListGenres.setItem(movie.getListGenres().toString());
				listfrequentGenres.add(itemListGenres);
			}
			
			hm.put(Constants.BIRTHYEAR, listfrequentBirthyear);
			hm.put(Constants.GENDER, listfrequentGender);
			hm.put(Constants.GENRES, listfrequentGenres);
			
			
			//System.out.println("&&&&& "+listfrequentBirthyear);
		}		
		return hm;
	}

	public List<Transaction> getTransactions(List<Movie> movies){
		List<Transaction> listTransaction = new ArrayList<>();
		
		for (int i = 0; i < movies.size(); i++) {
			transaction = new Transaction();
			transaction.setTransactionId(i);
			transaction.setMovie(movies.get(i));
			transaction.setAdded(false);
			listTransaction.add(transaction);
		}		
		return listTransaction;
	}
}

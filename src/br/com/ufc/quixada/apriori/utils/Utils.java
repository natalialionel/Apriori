package br.com.ufc.quixada.apriori.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.ufc.quixada.apriori.model.CombinedItem;
import br.com.ufc.quixada.apriori.model.FrequentItem;
import br.com.ufc.quixada.apriori.model.Movie;
import br.com.ufc.quixada.apriori.model.Transaction;

public class Utils {

	public List<String> splitList(String itens) {
		List<String> listItens = new ArrayList<String>();
		char split = '|';
		String aux = "";

		for (int i = 0; i < itens.length(); i++) {
			if (itens.charAt(i) != split) {
				aux += Character.toString(itens.charAt(i));
				if (i == itens.length() - 1) {
					listItens.add(aux);
				}
			} else {
				listItens.add(aux);
				aux = "";
			}
		}
		return listItens;
	}

	public FrequentItem itemFrequence(Movie movie, List<Transaction> listTransaction, Double minsuport) {
		int frequence = 0;
		FrequentItem frequent = new FrequentItem();
		List<FrequentItem> listFrequentItens = new ArrayList<FrequentItem>();
		List<Integer> transactionID = new ArrayList<Integer>();

		for (int i = 0; i < listTransaction.size(); i++) {
			if (listTransaction.get(i).getMovie().getMovieId().equals(movie.getMovieId())
					&& listTransaction.get(i).getMovie().getListGenres().toString()
							.equals(movie.getListGenres().toString())
					&& !listTransaction.get(i).isAdded()
					&& listTransaction.get(i).getMovie().getBirthyear().equals(movie.getBirthyear())) {
				frequence++;
				listTransaction.get(i).setAdded(true);
				transactionID.add(listTransaction.get(i).getTransactionId());
			}
		}

		if (frequence >= minsuport) {
			frequent.setFrequence(frequence);
			frequent.setListTransactionsID(transactionID);
			listFrequentItens.add(frequent);
			// System.out.println("=========Frequente -----------" + frequent);
		}
		return frequent;
	}

	public void frequentItem2(Movie movie, List<Transaction> listTransaction, Double minsuport){
		int suport = 0;
		FrequentItem frequent = new FrequentItem();
		List<FrequentItem> listFrequentItens = new ArrayList<FrequentItem>();
		List<Integer> transactionID = new ArrayList<Integer>();

		for (int i = 0; i < listTransaction.size(); i++) {
			if (listTransaction.get(i).getMovie().getBirthyear().equals(movie.getBirthyear())) {
				suport++;
				//listTransaction.get(i).setAdded(true);
				transactionID.add(listTransaction.get(i).getTransactionId());
				//System.out.println("=====BirthDay"+listTransaction.get(i).getMovie().getBirthyear());
			}
		}

		if (suport >= minsuport) {
			frequent.setFrequence(suport);
			frequent.setListTransactionsID(transactionID);
			listFrequentItens.add(frequent);
			//System.out.println("=========Frequente -----------" + frequent.toString());
		}

	}
	
	public List<CombinedItem> combineFrequentItems(List<FrequentItem> ListfrequentBirthyear, List<FrequentItem> ListfrequentGender,List<FrequentItem> ListfrequentGenres){
		List<CombinedItem> joins = new ArrayList<>();
		CombinedItem combinedItem = null;
		int count =1;
		
		for (FrequentItem itemOne : ListfrequentBirthyear){
			for (FrequentItem itemTwo : ListfrequentGender) {
				for(FrequentItem itemThree : ListfrequentGenres) {					
					//System.out.println(count+". "+itemOne.getItem() + " :: " + itemTwo.getItem() + " :: " + itemThree.getItem());
					combinedItem = new CombinedItem();
					combinedItem.setBirthyear(itemOne);
					combinedItem.setGender(itemTwo);
					combinedItem.setGenres(itemThree);
					joins.add(combinedItem);
					count ++;
				}
			}
		}
		
		for (CombinedItem combined : joins) {
			//System.out.println(""+combined.getBirthyear()+" "+combined.getGender() +" "+combined.getGenres());
		}
		
		return joins;
	}
	
	public void combineFrequentItemsAndPrint(){
		
	}
	
	public List<String> combineLists(List<String> listOne, List<String> listTwo) {
		List<String> listJoin = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		for (String birthday : listOne) {
			for (String gender : listTwo) {
				sb.setLength(0);
				sb.append(birthday).append(' ').append(gender).append(' ');
				listJoin.add(sb.toString());
			}
		}
		return listJoin;
	}
	
	/*public List<FrequentItem> CombineListItem(List<FrequentItem>listBirthyear, List<FrequentItem> listGender){
		List<FrequentItem> listJoin = new ArrayList<FrequentItem>();
		
	}*/

	public List<String> printAllCases(List<List<String>> listJoined) {
		List<String> resultJoin = new ArrayList<String>(listJoined.get(0));

		for (int i = 1; i < listJoined.size(); i++) {
			resultJoin = combineLists(resultJoin, listJoined.get(i));
		}

		int count = 1;
		for (String s : resultJoin) {
			System.out.printf(" "+count +" "+s+"\n");
			count++;
		}
		
		return resultJoin;
	}

	public List<CombinedItem> removeDuplicates(List<CombinedItem> listFrequentItem) {
		Set<CombinedItem> set = new HashSet<CombinedItem>();

		set.addAll(listFrequentItem);

		return new ArrayList<CombinedItem>(set);
	}

}

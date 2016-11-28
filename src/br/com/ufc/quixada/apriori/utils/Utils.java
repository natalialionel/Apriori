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
		Double frequence = 0.0;
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
		}
		return frequent;
	}

	public List<CombinedItem> combineFrequentTwoItems(List<FrequentItem> ListfrequentBirthyear,
			List<FrequentItem> ListfrequentGender) {
		List<CombinedItem> joins = new ArrayList<>();
		CombinedItem combinedItem = null;

		for (FrequentItem itemOne : ListfrequentBirthyear) {
			for (FrequentItem itemTwo : ListfrequentGender) {
				// System.out.println(count+". "+itemOne.getItem() + " :: " +
				// itemTwo.getItem() + " :: " + itemThree.getItem());
				combinedItem = new CombinedItem();
				combinedItem.setBirthyear(itemOne);
				combinedItem.setGender(itemTwo);
				joins.add(combinedItem);
			}
		}
		return joins;
	}

	public List<CombinedItem> combineAllFrequentItems(List<CombinedItem> listfrequentTwoItems,
			List<FrequentItem> listfrequentGenres) {

		List<CombinedItem> joins = new ArrayList<>();
		CombinedItem combinedItem = null;
		//int count = 1;

		for (CombinedItem itemOne : listfrequentTwoItems) {
			for (FrequentItem itemTwo : listfrequentGenres) {
				
				combinedItem = new CombinedItem();
				combinedItem.setBirthyear(itemOne.getBirthyear());
				combinedItem.setGender(itemOne.getGender());
				combinedItem.setGenres(itemTwo);

				joins.add(combinedItem);
				// count ++;
			}
		}
		/*for (CombinedItem combined : joins) {
			// System.out.println("¨¨"+count+". "+combined);
			//System.out.println(count+". "+itemOne.getBirthyear().getItem()+ " ::
				// "+itemOne.getGender().getItem()+ " :: "+itemTwo.getItem());
			count++;
		}*/
		return joins;
	}

	public List<CombinedItem> combineFrequentItems(List<FrequentItem> ListfrequentBirthyear,
			List<FrequentItem> ListfrequentGender, List<FrequentItem> ListfrequentGenres) {
		List<CombinedItem> joins = new ArrayList<>();
		CombinedItem combinedItem = null;
		//int count = 1;

		for (FrequentItem itemOne : ListfrequentBirthyear) {
			for (FrequentItem itemTwo : ListfrequentGender) {
				for (FrequentItem itemThree : ListfrequentGenres) {
					// System.out.println(count+". "+itemOne.getItem() + " :: "
					// + itemTwo.getItem() + " :: " + itemThree.getItem());
					combinedItem = new CombinedItem();
					combinedItem.setBirthyear(itemOne);
					combinedItem.setGender(itemTwo);
					combinedItem.setGenres(itemThree);
					joins.add(combinedItem);
					//count++;
				}
			}
		}
		return joins;
	}

	public void calculeConfiance(List<CombinedItem> listItensCombinate, List<FrequentItem> listItensFrequents,
			Double minconf) {
		Double confiance = 0.0;
		int count = 1;
		List<CombinedItem> listCombinate = new ArrayList<CombinedItem>();
		List<CombinedItem> aux  = new ArrayList<CombinedItem>();

		for (FrequentItem frequentItem : listItensFrequents) {
			for (CombinedItem combined : listItensCombinate) {
				confiance = combined.getFrequenceCombined() / frequentItem.getFrequence();

				if (confiance >= minconf) {
					combined.setConfianceCombined(confiance);
					aux.add(combined);
				}
			}
		}
		
		listCombinate = removeDuplicates(aux);
		
		for (CombinedItem combined : listCombinate) {
			System.out.println(count + ". A regras \t:" + combined.getBirthyear().getItem() + " e "
					+ combined.getGender().getItem() + " -> " + combined.getGenres().getItem()
					+ " tem confiança " + combined.getConfianceCombined() + " e suporte " + combined.getFrequenceCombined());
			count++;
		}
	}

	public List<CombinedItem> removeDuplicates(List<CombinedItem> listFrequentItem) {
		Set<CombinedItem> set = new HashSet<CombinedItem>();

		set.addAll(listFrequentItem);

		return new ArrayList<CombinedItem>(set);
	}

}

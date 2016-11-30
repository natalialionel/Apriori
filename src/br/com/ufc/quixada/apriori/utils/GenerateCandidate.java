package br.com.ufc.quixada.apriori.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.apriori.model.CombinedItem;
import br.com.ufc.quixada.apriori.model.FrequentItem;
import br.com.ufc.quixada.apriori.model.Movie;
import br.com.ufc.quixada.apriori.model.Transaction;

public class GenerateCandidate {

	//Método que calcula a frequência de cada item
	public List<FrequentItem> itemFrequences(List<Transaction> listTransactions, Double minsuport, Movie movie) {		
		Double frequenceGender = 0.0;
		Double frequenceListGenres = 0.0;
		Double frequenceBirthyear = 0.0;
		Double frequenceTitle = 0.0;
		FrequentItem frequentBirthyear = new FrequentItem();
		FrequentItem frequentGender = new FrequentItem();
		FrequentItem frequentListGenres = new FrequentItem();
		FrequentItem frequentTitle = new FrequentItem();
		List<FrequentItem> listFrequentItens = new ArrayList<FrequentItem>();
		Movie tempMovie = null;
		
		for (int i = 0; i < listTransactions.size(); i++) {
			tempMovie = listTransactions.get(i).getMovie();

			if (tempMovie.getBirthyear().equals(movie.getBirthyear()) && !listTransactions.get(i).isAddedBirthday()) {
				frequenceBirthyear++;
				listTransactions.get(i).setAddedBirthday(true);
			}

			if (tempMovie.getGender().equals(movie.getGender()) && !listTransactions.get(i).isAddedGender()) {
				frequenceGender++;
				listTransactions.get(i).setAddedGender(true);
			}

			if (tempMovie.getListGenres().equals(movie.getListGenres())
					&& !listTransactions.get(i).isAddedListGenres()) {
				frequenceListGenres++;
				listTransactions.get(i).setAddedListGenres(true);
			}
			
			if (tempMovie.getTitle().equals(movie.getTitle())
					&& !listTransactions.get(i).isAddedTitle()) {
				frequenceTitle++;
				listTransactions.get(i).setAddedTitle(true);
			}

		}
		//Verificando o suporte de cada item e adicionando a lista de itens frequentes
		if (frequenceBirthyear >= minsuport) {
			frequentBirthyear.setFrequence(frequenceBirthyear);
			frequentBirthyear.setItem("");
			listFrequentItens.add(0, frequentBirthyear);
		} else {
			listFrequentItens.add(0, null);
		}

		if (frequenceGender >= minsuport) {
			frequentGender.setFrequence(frequenceGender);
			frequentGender.setItem("");
			listFrequentItens.add(1, frequentGender);
		} else {
			listFrequentItens.add(1, null);
		}

		if (frequenceListGenres >= minsuport) {
			frequentListGenres.setFrequence(frequenceListGenres);
			frequentListGenres.setItem("");
			listFrequentItens.add(2, frequentListGenres);
		} else {
			listFrequentItens.add(2, null);
		}
		
		if (frequenceTitle >= minsuport) {
			frequentTitle.setFrequence(frequenceTitle);
			frequentTitle.setItem("");
			listFrequentItens.add(3, frequentTitle);
		} else {
			listFrequentItens.add(3, null);
		}				
		return listFrequentItens;
	}
	
	//Método que faz todas as combinações entre Birthyear e Gender
	public List<CombinedItem> twoItemFrequenceCombined(List<Transaction> listTransactions, List<CombinedItem> listCombinedItems, Double minsuport){
		Double frequence = 0.0;
		CombinedItem tempCombinedItem = null;
		Movie tempMovie = null;
		Utils utils = new Utils();
		List<CombinedItem> listCombined = new ArrayList<CombinedItem>();
		List<CombinedItem> listCombinedFrequent = new ArrayList<CombinedItem>();
		
		//System.out.println("-----------Frequente 2 listas-----------");
		
		for (int k = 0; k < listCombinedItems.size(); k++) {
			tempCombinedItem = listCombinedItems.get(k);
			for (int i = 0; i < listTransactions.size(); i++) {
				tempMovie = listTransactions.get(i).getMovie();
								
				if (tempMovie.getBirthyear().equals(tempCombinedItem.getBirthyear().getItem()) &&
						tempMovie.getGender().equals(tempCombinedItem.getGender().getItem()) &&
						!listTransactions.get(i).isAdded()) {
					//System.out.println(tempCombinedItem.toString());
					frequence++;
					tempCombinedItem.setFrequenceCombined(frequence);
					listCombined.add(tempCombinedItem);
					listTransactions.get(i).setAdded(true);
				}
			}
			frequence = 0.0;
		}
				
		/*System.out.println(" frequencia -> " + combinedItem.getFrequenceCombined() +
		" : " + combinedItem.getBirthyear().getItem() +
		" : " + combinedItem.getGender().getItem() + 
		" : " + combinedItem.getGenres().getItem());*/
		
		List<CombinedItem> aux = new ArrayList<>();		
		for (CombinedItem combinedItem : listCombined) {
			//Verificando o suporte de cada combinação 
			if(combinedItem.getFrequenceCombined()>= minsuport){
				aux.add(combinedItem);
			}
		}
		listCombinedFrequent = utils.removeDuplicates(aux);		
		
		return listCombinedFrequent;
	}
	
	public List<CombinedItem> itemThreeFrequencesCombined(List<Transaction> listTransactions, List<CombinedItem> lisCombinedItems, Double minsuport) {
		//System.out.println("\nEntrando no método itemFrequencesCombined....\n");
		Double frequence = 0.0;
		CombinedItem tempCombinedItem = null;
		Movie tempMovie = null;
		Utils utils = new Utils();
		List<CombinedItem> listCombined = new ArrayList<CombinedItem>();
		List<CombinedItem> listCombinedFrequent = new ArrayList<CombinedItem>();
		for (int k = 0; k < lisCombinedItems.size(); k++) {
			tempCombinedItem = lisCombinedItems.get(k);
			//System.out.println(tempCombinedItem.toString());
			for (int i = 0; i < listTransactions.size(); i++) {
				tempMovie = listTransactions.get(i).getMovie();
				//System.out.println(tempMovie.toString());
					
				if (tempMovie.getBirthyear().equals(tempCombinedItem.getBirthyear().getItem()) &&
						tempMovie.getGender().equals(tempCombinedItem.getGender().getItem()) &&
						tempMovie.getListGenres().toString().equals(tempCombinedItem.getGenres().getItem()) /*&&
						!listTransactions.get(i).isAdded()*/) {
					//System.out.println(tempCombinedItem.toString());
					frequence++;
					tempCombinedItem.setFrequenceCombined(frequence);
					listCombined.add(tempCombinedItem);
					//listTransactions.get(i).setAdded(true);
				}
			}
			frequence = 0.0;
		}
		
		/*System.out.println(" frequencia -> " + combinedItem.getFrequenceCombined() +
		" : " + combinedItem.getBirthyear().getItem() +
		" : " + combinedItem.getGender().getItem() + 
		" : " + combinedItem.getGenres().getItem());*/
		
		List<CombinedItem> aux = new ArrayList<>();
		for (CombinedItem combinedItem : listCombined) {
			if(combinedItem.getFrequenceCombined()>= minsuport){
				aux.add(combinedItem);
			}
		}
		listCombinedFrequent = utils.removeDuplicates(aux);
		
		/*for (CombinedItem c : listCombinedFrequent) {
		//	System.out.println(c +" aparece em "+c.getFrequenceCombined() +" de " +listTransactions.size());		
		}*/
		
		return listCombinedFrequent;
	}
			
	public List<CombinedItem> itemAllFrequencesCombined(List<Transaction> listTransactions, List<CombinedItem> listCombinedItems, Double minsuport) {
		Double frequence = 0.0;
		CombinedItem tempCombinedItem = null;
		Movie tempMovie = null;
		Utils utils = new Utils();
		List<CombinedItem> listCombined = new ArrayList<CombinedItem>();
		List<CombinedItem> listCombinedFrequent = new ArrayList<CombinedItem>();
		
		for (int k = 0; k < listCombinedItems.size(); k++) {
			tempCombinedItem = listCombinedItems.get(k);
			System.out.println(tempCombinedItem.toString());
			for (int i = 0; i < listTransactions.size(); i++) {
				tempMovie = listTransactions.get(i).getMovie();
					
				if (tempMovie.getBirthyear().equals(tempCombinedItem.getBirthyear().getItem()) &&
						tempMovie.getGender().equals(tempCombinedItem.getGender().getItem()) &&
						tempMovie.getListGenres().toString().equals(tempCombinedItem.getGenres().getItem()) &&
						tempMovie.getTitle().toString().equals(tempCombinedItem.getTitle().getItem()) &&
						!listTransactions.get(i).isAdded()) {
					//System.out.println(tempCombinedItem.toString());
					frequence++;
					tempCombinedItem.setFrequenceCombined(frequence);
					listCombined.add(tempCombinedItem);
					listTransactions.get(i).setAdded(true);
				}
			}
			frequence = 0.0;
		}
		
		/*for (CombinedItem combinedItem : listCombinedFrequent) {
			System.out.println(" frequencia -> " + combinedItem.getFrequenceCombined() +
			" : " + combinedItem.getBirthyear().getItem() +
			" : " + combinedItem.getGender().getItem() + 
			" : " + combinedItem.getGenres().getItem() +
			" : " + combinedItem.getTitle().getItem());
		}*/
		
		List<CombinedItem> aux = new ArrayList<>();
		for (CombinedItem combinedItem : listCombined) {
			if(combinedItem.getFrequenceCombined()>= minsuport){
				aux.add(combinedItem);
			}
		}
		listCombinedFrequent = utils.removeDuplicates(aux);
		
		/*for (CombinedItem c : listCombinedFrequent) {
			System.out.println(c +" aparece em "+c.getFrequenceCombined() +" de " +listTransactions.size());		
		}*/
		
		return listCombinedFrequent;
	}
	
}

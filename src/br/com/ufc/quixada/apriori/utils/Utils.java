package br.com.ufc.quixada.apriori.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.ufc.quixada.apriori.model.CombinedItem;
import br.com.ufc.quixada.apriori.model.FrequentItem;

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
		/*for (CombinedItem item : joins) {
			System.out.println("+++"+item.print());
			
		}*/
		
		return joins;
	}

	public List<CombinedItem> combineThreeFrequentItems(List<CombinedItem> listfrequentTwoItems,
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
		
		return joins;
	}
	
	
	public List<CombinedItem> combineAllItens(List<CombinedItem> listfrequentThreeItems,List<FrequentItem> listfrequentTitle){
		List<CombinedItem> joins = new ArrayList<>();
		CombinedItem combinedItem = null;
		//int count = 1;

		for (CombinedItem itemOne : listfrequentThreeItems) {
			for (FrequentItem itemTwo : listfrequentTitle) {
				
				combinedItem = new CombinedItem();
				combinedItem.setBirthyear(itemOne.getBirthyear());
				combinedItem.setGender(itemOne.getGender());
				combinedItem.setGenres(itemOne.getGenres());
				combinedItem.setTitle(itemTwo);

				joins.add(combinedItem);
				// count ++;
			}
		}		
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

	public void calculeConfiance(List<CombinedItem> listItensCombinate, List<CombinedItem> listTwoItensCombinate,
			double minconf) {
		double confiance = 0.0;
		int count = 1;
		List<CombinedItem> listCombinate = new ArrayList<CombinedItem>();
		List<CombinedItem> aux  = new ArrayList<CombinedItem>();

		for (CombinedItem combinateTwoItems : listTwoItensCombinate) {
			for (CombinedItem combined : listItensCombinate) {
				confiance = combined.getFrequenceCombined() / combinateTwoItems.getFrequenceCombined();
				if (confiance >= minconf ) {
					combined.setConfianceCombined(confiance);
					aux.add(combined);
				}
			}
		}
		
		listCombinate = removeDuplicates(aux);//Removendo elementos duplicados
						
		for (CombinedItem combined : listCombinate) {
			//Imprimindo a regra encontrada
			System.out.println(count + ". A regras \t:" + combined.getBirthyear().getItem() + " e "
					+ combined.getGender().getItem() + " -> " + combined.getGenres().getItem()
					+ " tem confiança " + combined.getConfianceCombined() + " e suporte " + combined.getFrequenceCombined());
			count++;
		}
	}
	//Remoção de combinações duplicadas 
	public List<CombinedItem> removeDuplicates(List<CombinedItem> listFrequentItem) {
		Set<CombinedItem> set = new HashSet<CombinedItem>();

		set.addAll(listFrequentItem);

		return new ArrayList<CombinedItem>(set);
	}

}

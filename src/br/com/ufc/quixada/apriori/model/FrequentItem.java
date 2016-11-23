package br.com.ufc.quixada.apriori.model;

import java.util.ArrayList;
import java.util.List;

public class FrequentItem {
	private Integer frequence;
	private List<Integer> listTransactionsID;

	public FrequentItem() {
		this.frequence = 0;
		this.listTransactionsID= new ArrayList<Integer>() ;
	}

	public List<Integer> getListTransactionsID() {
		return listTransactionsID;
	}

	public void setListTransactionsID(List<Integer> listTransactionsID) {
		this.listTransactionsID = listTransactionsID;
	}

	public Integer getFrequence() {
		return frequence;
	}

	public void setFrequence(Integer frequence) {
		this.frequence = frequence;
	}

	@Override
	public String toString() {
		return "FrequentItem [frequence=" + frequence + ", listTransactionsID=" + listTransactionsID + "]";
	}

			

}

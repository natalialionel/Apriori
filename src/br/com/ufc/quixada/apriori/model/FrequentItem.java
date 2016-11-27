package br.com.ufc.quixada.apriori.model;

import java.util.ArrayList;
import java.util.List;

public class FrequentItem {
	private Integer frequence;
	private List<Integer> listTransactionsID;
	private String item;

	public FrequentItem(Integer frequence, String item) {
		this.frequence = frequence;
		this.item = item;
	}
	
	public FrequentItem() {
		this.frequence = 0;
		this.listTransactionsID= new ArrayList<Integer>() ;
		this.item = "";
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "" + frequence + ", item = " + item + "";
	}


}

package br.com.ufc.quixada.apriori.model;

import java.util.ArrayList;
import java.util.List;

public class FrequentItem {
	private Double frequence;
	private Double confiance;
	private List<Integer> listTransactionsID;
	private String item;

	
	public FrequentItem(Double frequence, String item) {
		this.frequence = frequence;
		this.item = item;
	}
	
	public FrequentItem() {
		this.frequence = 0.0;
		this.listTransactionsID= new ArrayList<Integer>() ;
		this.item = "";
	}

	public List<Integer> getListTransactionsID() {
		return listTransactionsID;
	}

	public void setListTransactionsID(List<Integer> listTransactionsID) {
		this.listTransactionsID = listTransactionsID;
	}

	public Double getFrequence() {
		return frequence;
	}

	public void setFrequence(Double frequence) {
		this.frequence = frequence;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getConfiance() {
		return confiance;
	}

	public void setConfiance(Double confiance) {
		this.confiance = confiance;
	}

	@Override
	public String toString() {
		return "frequence=" + frequence + ", confiance=" + confiance + ", item=" + item + "]";
	}

	


}

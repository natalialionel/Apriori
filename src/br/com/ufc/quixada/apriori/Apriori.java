package br.com.ufc.quixada.apriori;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.ufc.quixada.apriori.data.RetriveData;
import br.com.ufc.quixada.apriori.data.model.FrequentItem;
import br.com.ufc.quixada.apriori.data.model.Movie;
import br.com.ufc.quixada.apriori.data.model.Transaction;
import br.com.ufc.quixada.apriori.utils.Utils;


public class Apriori {
	public static void main(String[] args) throws Exception{
		
		String path ="/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeader_Reduzido2.csv";
		//String path ="/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeader.csv";
		
		try {
			List<Movie> listMovies = new RetriveData().getDataSetFromFile(path);			
			Double minsuport;
			
			
			minsuport = 2.0;
			
			runApriori(listMovies, minsuport);
			
						
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
	
	public static void runApriori(List<Movie> listMovies, Double minsuport){
		
		Double minconf;
		Utils utils = new Utils();		
		Transaction transaction;
		List <Transaction> listTransaction = new ArrayList<Transaction>();
		List<List<Integer>> list = new ArrayList<>();
		FrequentItem item = new FrequentItem();
		List<Movie> listMoviesFrequent = new ArrayList<>();
		List<FrequentItem> aux; 
		List<String> listOne = new ArrayList<String>();
		List<String> listTwo = new ArrayList<String>();
		List<String> listThree = new ArrayList<String>();
		
		for(int i =0; i<listMovies.size(); i++){
			transaction = new Transaction();
			transaction.setTransactionId(i);
			transaction.setMovie(listMovies.get(i));
			transaction.setAdded(false);
			listTransaction.add(transaction);
			
			//System.out.println("-----------------Lista de Transação 1 "+listTransaction.get(i));
		}
		
		for (Movie movie : listMovies) {
			item = utils.itemFrequence(movie, listTransaction, minsuport);
			if(item.getFrequence() >= minsuport){
				movie.setFrequentItem(item);
				
				System.out.println("Lista de itens frequentes "+ movie.toString());
				list.add(movie.getFrequentItem().getListTransactionsID());
				listMoviesFrequent.add(movie);
				listOne.add(movie.getBirthyear());
				listTwo.add(movie.getGender());
				listThree.add(movie.getListGenres().toString());
			}
		}
		
		utils.CombineLists(listOne, listTwo);
		List<List<String>> totalList = Arrays.asList(listOne,listTwo,listThree);

	    utils.printAllCases(totalList);
		//aux = utils.removeDuplicates(listFrequentItens);
	}
	
	public static void generateRules(){}

	
	
}

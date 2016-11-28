package br.com.ufc.quixada.apriori;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ufc.quixada.apriori.constants.Constants;
import br.com.ufc.quixada.apriori.data.RetriveData;
import br.com.ufc.quixada.apriori.model.CombinedItem;
import br.com.ufc.quixada.apriori.model.FrequentItem;
import br.com.ufc.quixada.apriori.model.Movie;
import br.com.ufc.quixada.apriori.utils.GenerateCandidate;
import br.com.ufc.quixada.apriori.utils.Prune;
import br.com.ufc.quixada.apriori.utils.Utils;

public class Apriori {
	
	private static Double minconf;
	private static Prune prune;
	private static Map<String, List<FrequentItem>> hm;
	private static Utils utils;
	private static GenerateCandidate generateCandidate;
	private static List<CombinedItem> combinedAllItems;
	private static List<CombinedItem> combinedTwoItems;
	private static List<CombinedItem> combinedItemsFrequents;
	private static List<CombinedItem> combinedAllItemsFrequents;
	
	
	
	public static void main(String[] args) throws Exception {
		//String path = "/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeader_Reduzido.csv";
		//String path = "/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeader_Reduzido2.csv";
		//String path = "/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeaderReduzidoManipulado.csv";
		//String path = "/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeader_Reduzido3.csv";
		//String path ="/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeader.csv";
		//String path = "/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeaderReduzidoManipulado2.csv";
		String path ="/home/lionel/Dropbox/Topicos/Trabalho2/unionAll_Pronto_SemHeaderFinal.csv";

		try {
			List<Movie> listMovies = new RetriveData().getDataSetFromFile(path);
			Double minsuport;

			minsuport = 12.0;

			runApriori(listMovies, minsuport);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void runApriori(List<Movie> listMovies, Double minsuport) {
		initialize();
		
		hm = prune.generateCandidates(listMovies, minsuport);//Calculando frequêcia de cada item
		combinedTwoItems = utils.combineFrequentTwoItems(hm.get(Constants.BIRTHYEAR), hm.get(Constants.GENDER));
		combinedItemsFrequents = generateCandidate.twoItemFrequenceCombined(prune.getTransactions(listMovies), combinedTwoItems, minsuport);
		
		
		combinedAllItems = utils.combineAllFrequentItems(combinedItemsFrequents, hm.get(Constants.GENRES));
		combinedAllItemsFrequents = generateCandidate.itemFrequencesCombined(prune.getTransactions(listMovies), combinedAllItems, minsuport);
		
		minconf = 0.94;
		utils.calculeConfiance(combinedAllItemsFrequents, hm.get(Constants.GENRES), minconf);
	
		
		
		//combinedItems = utils.combineFrequentTwoItems(hm.get(Constants.GENRES), hm.get(combinedItemsFrequents));
		//generateCandidate.itemFrequencesCombined(prune.getTransactions(listMovies), combinedItems, minsuport);
		/*combinedItems = utils.combineFrequentItems(hm.get(Constants.BIRTHYEAR), hm.get(Constants.GENDER), hm.get(Constants.GENRES));
		generateCandidate.itemFrequencesCombined(prune.getTransactions(listMovies), combinedItems, minsuport);*/
		
		
	}

	public static void initialize(){
		minconf = null;
		prune = new Prune();
		hm = new HashMap<String, List<FrequentItem>>();
		utils = new Utils();
		generateCandidate = new GenerateCandidate();
	}
}

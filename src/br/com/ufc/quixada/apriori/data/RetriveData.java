package br.com.ufc.quixada.apriori.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.apriori.data.model.Movie;
import br.com.ufc.quixada.apriori.utils.Utils;

public class RetriveData {
	
	public List<Movie> getDataSetFromFile(String pathCSV) throws IOException{
		Utils utils = new Utils();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		String[] result = null;
		String csvFile = pathCSV;
		
		
		List<Movie> dataSet = new ArrayList<>();
		Movie movie = null;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			
			while ((line = br.readLine()) != null) {
				result = line.split(cvsSplitBy);
				
				
				if (result[0] == null || result[0].equals(""))
					continue;
								
				String movieId = result[0];
				String title = result[1].trim();
				String listGenre = result[2];
				String listDirectors = result[3];
				Double averageCriticRating = Double.parseDouble(result[5].replaceAll("\\s+", ""));
				Integer numberCriticRatings = Integer.valueOf(result[6].replaceAll("\\s+", ""));
				String birthyear = result[7];
				String gender = result[8].trim();
				Double convertedRating = Double.valueOf(result[9]);
				
				movie = new Movie();
				movie.setMovieId(movieId);
				movie.setTitle(title);
				movie.setListGenres(utils.splitList(listGenre.trim()));
				movie.setListDirectors(utils.splitList(listDirectors.trim()));
				movie.setAverageCriticRating(averageCriticRating);
				movie.setNumberCriticRatings(numberCriticRatings);
				movie.setBirthyear(birthyear);
				movie.setGender(gender);
				movie.setConvertedRating(convertedRating);
				
				dataSet.add(movie);
							
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
		return dataSet;
	}
		
}




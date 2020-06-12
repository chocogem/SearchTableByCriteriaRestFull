package com.demo.movie.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.movie.entities.Movie;
import com.demo.movie.repositories.MovieRepository;


@Component
public class InitDataController {
	 @Autowired
	 MovieRepository movieRepository;
	
	 public void clearData() {
		 movieRepository.deleteAll();
	 }
	 public void createMoviesData(InputStream  inputStream) {
		 saveMoviesData(inputStream);
	 }
	
	 public void saveMoviesData(InputStream  inputStream) {
		  Scanner sc = null;
		  try {
		
		      sc = new Scanner(inputStream, "UTF-8");
		      List<Movie> movieList = new ArrayList<>();
		      Movie movie = null;
		      String readLine = "";
		      String delimiter = ",";
		      String delimiterGenres = "\\|";
		      String[] genres;
		      int i=1;
		      
		      while (sc.hasNextLine()) {
		    	  if(i==1) {
		    		  sc.nextLine();
		    	  }else {
		    		  readLine = sc.nextLine();
		    		  String[] reads= readLine.split(delimiter, 3);
		    		  movie = new Movie();
		    		  movie.setMovieId(reads[0]);
		    		  movie.setTitle(reads[1]);
		    		  genres = reads[2].split(delimiterGenres);
		    		  movie.setGenres(genres);
		    		  movieList.add(movie);
		    	 }
		    		  
		          i++;
		      }
		      if(movieList!=null&&movieList.size()>0)
		    	  movieRepository.saveAll(movieList);
		      if (sc.ioException() != null) {
		    	  throw sc.ioException();
	        }
		  }catch (Exception e) {
				e.printStackTrace();
			  } finally {
			      if (inputStream != null) {
			          try {
						inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      }
			      if (sc != null) {
			          sc.close();
			      }
			  }
	 
	  }
	 
	 
		  
		  
		  
	  
}

package com.demo.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.movie.entities.Movie;
import com.demo.movie.repositories.MovieRepository;



@Service
public class MovieService {
		@Autowired
		MovieRepository movieRepository;
		
		@Autowired
	    public MovieService(MovieRepository movieRepository) {
	        this.movieRepository = movieRepository;
	    }
	
		public List<Movie> searchMoviesByKeyword(String option,String keyword){
			
			List<Movie>moviesResponse = new ArrayList<>();
			if("title".equals(option)) {
				moviesResponse =  movieRepository.searchMoviesByTitle(escapeMetaCharacters(keyword));
			}else if("genre".equals(option)) {
				moviesResponse = movieRepository.searchMoviesByGenre(escapeMetaCharacters(keyword));
			}else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			return moviesResponse;
		} 
	
		public List<Movie> getAllMovie(){
		      return movieRepository.findAll();
		} 
		public String escapeMetaCharacters(String inputString){
		    final String[] metaCharacters = {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&","%"};

		    for (int i = 0 ; i < metaCharacters.length ; i++){
		        if(inputString.contains(metaCharacters[i])){
		            inputString = inputString.replace(metaCharacters[i],"\\"+metaCharacters[i]);
		        }
		    }
		    return inputString;
		}
	
	
}

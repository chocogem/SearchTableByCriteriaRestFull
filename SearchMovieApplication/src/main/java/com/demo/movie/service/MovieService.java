package com.demo.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.movie.controller.InitDataController;
import com.demo.movie.entities.Movie;
import com.demo.movie.repositories.MovieRepository;



@Service
public class MovieService {
		@Autowired
		MovieRepository movieRepository;
		@Autowired
		private MongoTemplate mongoTemplate;
		
		@Autowired
	    public MovieService(MovieRepository movieRepository,MongoTemplate mongoTemplate) {
	        this.movieRepository = movieRepository;
	        this.mongoTemplate = mongoTemplate;
	    }
	
		public List<Movie> searchMoviesByKeyword(String option,String keyword){
			List<Movie>moviesResponse = new ArrayList<>();
			if("title".equals(option)) {
				moviesResponse =  movieRepository.searchMoviesByTitle(keyword);
			}else if("genre".equals(option)) {
				String[] keywordArr = {keyword};
				moviesResponse = movieRepository.searchMoviesByGenre(keywordArr);
			}else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			
			return moviesResponse;
		} 
	
		public List<Movie> getAllMovie(){
		      return movieRepository.findAll();
		} 
		
	
	
}

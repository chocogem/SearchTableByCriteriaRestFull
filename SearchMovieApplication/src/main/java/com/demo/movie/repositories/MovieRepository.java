package com.demo.movie.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.movie.entities.Movie;

public interface MovieRepository extends MongoRepository<Movie, String>{
	@Query("{ 'title' :{ $regex :?0 , $options: 'i'} }")
    List<Movie> searchMoviesByTitle(String keyword);
	
	@Query("{'genres' :{ $in :?0 }}")
	List<Movie> searchMoviesByGenre(String[] keyword);
	//List<Movie> findByGenresIn(String[] tags);
}

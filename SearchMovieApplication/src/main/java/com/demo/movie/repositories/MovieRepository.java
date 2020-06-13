package com.demo.movie.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.movie.entities.Movie;

public interface MovieRepository extends MongoRepository<Movie, String>{
	@Query(value="{'title' : { $regex:?0 , $options: 'i'}}",sort="{ 'movieId': 1 }")
    List<Movie> searchMoviesByTitle(String keyword);
	
	@Query(value="{'genres' :{ $in :[{$regex:?0 , $options: 'i' }] }}",sort="{ 'movieId': 1 }")
	List<Movie> searchMoviesByGenre(String keyword);
	//List<Movie> findByGenresIn(String[] tags);
	
	
	//List<Movie>findByTitleContaining(String keyword);
}

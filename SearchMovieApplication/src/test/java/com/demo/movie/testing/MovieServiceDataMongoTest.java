package com.demo.movie.testing;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.movie.entities.Movie;
import com.demo.movie.repositories.MovieRepository;
import com.demo.movie.service.MovieService;

@Ignore("Please Remove this annotation if you want to do unit test(it will connect to MongoDb.)")
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@RunWith(SpringRunner.class)
public class MovieServiceDataMongoTest {
		private MovieService movieService;
		@Autowired 
		MovieRepository movieRepository;
		@Before
	    public void setUp() {
			movieService = new MovieService(movieRepository);
			movieRepository.deleteAll();
			
	    }
		@After
	    public void tearDown() {
			movieRepository.deleteAll();
	    }

		@Test
		public void test_searchReviewByTitle(){
			 Movie movie;
       		 String paramOption = "title";
	   		 String paramKeyword = "Toy";
			 List<Movie> movies = new ArrayList<Movie>();
			 movie = new Movie();
			 movie.setMovieId(1);
			 movie.setTitle("Toy Story (1995)");
			 String[] genres1 = {"Adventure","Animation","Children","Comedy","Fantasy"};
			 movie.setGenres(genres1);
			 movies.add(movie);
			 
			 movie = new Movie();
			 movie.setMovieId(2253);
			 movie.setTitle("Toys (1992)");
			 String[] genres2 = {"Comedy","Fantasy"};
			 movie.setGenres(genres2);
			 movies.add(movie);
			 
			 movieRepository.saveAll(movies);
			 List<Movie> expected = movieService.searchMoviesByKeyword(paramOption,paramKeyword);
			 Assert.assertNotNull(expected);
			 Assert.assertEquals(2, expected.size());
		} 
		
		@Test
		public void test_searchReviewByTitleNotFound(){
       		 String paramOption = "title";
	   		 String paramKeyword = "Toy";
			 List<Movie> expected = movieService.searchMoviesByKeyword(paramOption,paramKeyword);
			 Assert.assertNotNull(expected);
			 Assert.assertEquals(0, expected.size());
		} 
		@Test
		public void test_searchReviewByGenre(){
			 Movie movie;
       		 String paramOption = "genre";
	   		 String paramKeyword = "Comedy";
			 List<Movie> movies = new ArrayList<Movie>();
			 movie = new Movie();
			 movie.setMovieId(1);
			 movie.setTitle("Toy Story (1995)");
			 String[] genres1 = {"Adventure","Animation","Children","Comedy","Fantasy"};
			 movie.setGenres(genres1);
			 movies.add(movie);
			 
			 movie = new Movie();
			 movie.setMovieId(2253);
			 movie.setTitle("Toys (1992)");
			 String[] genres2 = {"Comedy","Fantasy"};
			 movie.setGenres(genres2);
			 movies.add(movie);
			 
			 movieRepository.saveAll(movies);
			 List<Movie> expected = movieService.searchMoviesByKeyword(paramOption,paramKeyword);
			 Assert.assertNotNull(expected);
			 Assert.assertEquals(2, expected.size());
		} 
		
		@Test
		public void test_searchReviewByGenreNotFound(){
       		 String paramOption = "genre";
	   		 String paramKeyword = "Comedy";
			 List<Movie> expected = movieService.searchMoviesByKeyword(paramOption,paramKeyword);
			 Assert.assertNotNull(expected);
			 Assert.assertEquals(0, expected.size());
		} 
		
	
}

package com.demo.movie.testing;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.movie.entities.Movie;
import com.demo.movie.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MovieServiceControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
    private MovieService movieService;
 
    @Test
   	public void test_searchMovieByTitle() {
       	 try {
   		     Movie movie;
       		 String paramOption = "title";
	   		 String paramKeyword = "Story";
			 List<Movie> movies = new ArrayList<Movie>();
			 movie = new Movie();
			 movie.setMovieId("1");
			 movie.setTitle("Toy Story (1995)");
			 movie.setVersion(1L);
			 String[] genres1 = {"Adventure","Animation","Children","Comedy","Fantasy"};
			 movie.setGenres(genres1);
			 movies.add(movie);
			 
			 movie = new Movie();
			 movie.setMovieId("2253");
			 movie.setTitle("Toys (1992)");
			 movie.setVersion(1L);
			 String[] genres2 = {"Comedy","Fantasy"};
			 movie.setGenres(genres2);
			 movies.add(movie);
			 
			 given(movieService.searchMoviesByKeyword(paramOption,paramKeyword)).willReturn(movies);
   	        
   	        
   	         mockMvc.perform(get("/movies/")
   	        		 .param("option", paramOption)
   	         		 .param("keyword", paramKeyword))
   	           .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().json("[{\"movieId\":\"1\",\"title\":\"Toy Story (1995)\",\"genres\":[\"Adventure\",\"Animation\",\"Children\",\"Comedy\",\"Fantasy\"],\"version\":1},{\"movieId\":\"2253\",\"title\":\"Toys (1992)\",\"genres\":[\"Comedy\",\"Fantasy\"],\"version\":1}]"));
   		
   		
       	 
       	 
       	 
       	 } catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
     	}
   	}
    @Test
   	public void test_searchMovieByGenre() {
       	 try {
   		     Movie movie;
       		 String paramOption = "genre";
	   		 String paramKeyword = "Comedy";
			 List<Movie> movies = new ArrayList<Movie>();
			 movie = new Movie();
			 movie.setMovieId("1");
			 movie.setTitle("Toy Story (1995)");
			 movie.setVersion(1L);
			 String[] genres1 = {"Adventure","Animation","Children","Comedy","Fantasy"};
			 movie.setGenres(genres1);
			 movies.add(movie);
			 
			 movie = new Movie();
			 movie.setMovieId("2253");
			 movie.setTitle("Toys (1992)");
			 movie.setVersion(1L);
			 String[] genres2 = {"Comedy","Fantasy"};
			 movie.setGenres(genres2);
			 movies.add(movie);
			 
			 given(movieService.searchMoviesByKeyword(paramOption,paramKeyword)).willReturn(movies);
   	        
   	        
   	         mockMvc.perform(get("/movies/")
   	        		 .param("option", paramOption)
   	         		 .param("keyword", paramKeyword))
   	           .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().json("[{\"movieId\":\"1\",\"title\":\"Toy Story (1995)\",\"genres\":[\"Adventure\",\"Animation\",\"Children\",\"Comedy\",\"Fantasy\"],\"version\":1},{\"movieId\":\"2253\",\"title\":\"Toys (1992)\",\"genres\":[\"Comedy\",\"Fantasy\"],\"version\":1}]"));
   		
   		
       	 
       	 
       	 
       	 } catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
     	}
   	}
    
    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	
}

package com.demo.movie.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.movie.entities.Movie;
import com.demo.movie.service.MovieService;
@RestController
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<Movie> searchMovieByKeyword(@RequestParam("option") String option,@RequestParam("keyword") String keyword) {
		return movieService.searchMoviesByKeyword(option, keyword);
		
	}
	
	
	
}

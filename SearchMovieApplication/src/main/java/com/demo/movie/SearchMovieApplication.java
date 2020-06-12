package com.demo.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;




@SpringBootApplication
public class SearchMovieApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(SearchMovieApplication.class, args);
		
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SearchMovieApplication.class);
	}

}

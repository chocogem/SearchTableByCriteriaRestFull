package com.demo.movie;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.demo.movie.controller.InitDataController;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
  @Autowired
  InitDataController initDataController;
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
      init();
  }
  
  private void init() {
	  try {
		 initDataController.clearData();
	     ClassLoader classLoader = getClass().getClassLoader();
	     InputStream  inputStream =  classLoader.getResourceAsStream("data/movies.csv");
	     initDataController.createMoviesData(inputStream);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  
  }

  
}
package com.elektra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetoEktApplication {
	
	private static Logger LOG = LoggerFactory.getLogger(RetoEktApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RetoEktApplication.class, args);
		LOG.info("Iniciando mi aplicacion");
		
	}

}

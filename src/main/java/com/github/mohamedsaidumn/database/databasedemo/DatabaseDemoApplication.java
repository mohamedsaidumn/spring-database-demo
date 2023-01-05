package com.github.mohamedsaidumn.database.databasedemo;

import com.github.mohamedsaidumn.database.databasedemo.entity.Person;
import com.github.mohamedsaidumn.database.databasedemo.jdbc.PersonJbdcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class DatabaseDemoApplication  implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJbdcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users --> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("Deleting 10002 --> Number of rows deleted -> {}", dao.deleteById(10002));
		logger.info("Inserting -> {}",
				dao.insert(new Person(10004, "Tara", "Berlin", new Date(1000))));
		logger.info("Update 10003 -> {}",
				dao.update(new Person(10003, "Pieter", "Utrecht", new Date(2000))));


	}
}

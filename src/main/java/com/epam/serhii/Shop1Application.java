package com.epam.serhii;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.Shoes;
import model.ShoesCategory;
import repository.ShoesCategoryRepository;

@SpringBootApplication
public class Shop1Application implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(Shop1Application.class);
	
	@Autowired
	private ShoesCategoryRepository shoesCategoryRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(Shop1Application.class, args);
	}

	@Override
	@Transactional
	
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		ShoesCategory categoryA = new ShoesCategory("Category A");
		Set shoesAs = new HashSet<Shoes>() {{
			add(new Shoes("Shoes A1", categoryA));
			add(new Shoes("Shoes A2", categoryA));
			add(new Shoes("Shoes A3", categoryA));
		}};
		categoryA.setShoes(shoesAs);
		
		ShoesCategory categoryB = new ShoesCategory("Category A");
		Set shoesBs = new HashSet<Shoes>() {{
			add(new Shoes("Shoes B1", categoryB));
			add(new Shoes("Shoes B2", categoryB));
			add(new Shoes("Shoes B3", categoryB));
		}};
		categoryB.setShoes(shoesBs);
		
		
		shoesCategoryRepository.save(new HashSet<ShoesCategory>() {{
			add(categoryA);
			add(categoryB);
			
		}});
		
		for (ShoesCategory shoesCategory : shoesCategoryRepository.findAll()) {
			logger.info(shoesCategory.toString());
		}
		}
	}
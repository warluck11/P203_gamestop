package com.itvedant.dependancyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependancyInjectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DependancyInjectionApplication.class, args);
	}

	@Autowired
	Student s1;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		s1.setId(101);
		s1.setName("Harry");
		s1.setAge(24);
		s1.setMarks(45.6f);
		
		System.out.println(s1);
		
	}

}

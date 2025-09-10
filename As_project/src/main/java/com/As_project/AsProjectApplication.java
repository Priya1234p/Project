package com.As_project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.As_project.entity.Student;
import com.As_project.repository.StudentRepository;


@SpringBootApplication
@EntityScan(basePackages = "com.As_project.entity")
@EnableJpaRepositories(basePackages = "com.As_project.repository")
public class AsProjectApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context =SpringApplication.run(AsProjectApplication.class, args);
	
	StudentRepository studentrepo = context.getBean(StudentRepository.class);
	
	Student s = new Student();
	s.setId(123);
	s.setName("Ram");
	s.setRank(7676);
	s.setGender("Male");
	studentrepo.save(s);
	System.out.println("Record is inserted.....");
	}
	
   
}

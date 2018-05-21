package com.pracitce.person;

import com.pracitce.person.db.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonApplication implements CommandLineRunner {

    @Autowired
    PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        // clear all record if existed before do the tutorial with new data
        repository.deleteAll();
    }

}

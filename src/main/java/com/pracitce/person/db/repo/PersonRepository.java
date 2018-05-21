package com.pracitce.person.db.repo;

import com.pracitce.person.db.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByName (String name);
}

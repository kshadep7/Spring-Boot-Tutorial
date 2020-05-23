package com.example.springtutorial.demo.dao;

import com.example.springtutorial.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("pseudoDao")
public class PseudoPersonDataAccessService implements PersonDao {

    public static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPersons() {
        return db;
    }
}

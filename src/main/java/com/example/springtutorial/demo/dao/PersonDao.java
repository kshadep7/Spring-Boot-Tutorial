package com.example.springtutorial.demo.dao;

import com.example.springtutorial.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    public List<Person> getAllPersons();
}

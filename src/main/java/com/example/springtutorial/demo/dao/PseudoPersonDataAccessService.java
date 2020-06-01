package com.example.springtutorial.demo.dao;

import com.example.springtutorial.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return db.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personToDelete = selectPersonById(id);
        if (!personToDelete.isPresent())
            return 0;
        db.remove(personToDelete.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person newPerson) {
        return selectPersonById(id)
                .map(person -> {
                    int index = db.indexOf(person);
                    if (index >= 0) {
                        db.set(index, new Person(id, newPerson.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}

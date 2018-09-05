package com.alikarami.employees.model;

import java.util.ArrayList;
import java.util.List;

public class simplePersonDAO implements PersonDAO {

    private List<Person> people;

    public simplePersonDAO() {
        this.people = new ArrayList<>();
    }

    @Override
    public boolean add(Person person) {
        return people.add(person);
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(people);
    }

    @Override
    public Person get(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}

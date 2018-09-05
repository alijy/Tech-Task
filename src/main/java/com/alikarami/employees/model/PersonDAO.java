package com.alikarami.employees.model;

import java.util.List;

public interface PersonDAO {

    boolean add(Person person);

    List<Person> findAll();
}

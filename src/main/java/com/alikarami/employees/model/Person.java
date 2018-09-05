package com.alikarami.employees.model;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String nin;

    public Person(String name, int age, String nin) {
        this.name = name;
        this.age = age;
        this.nin = nin;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNin() {
        return nin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(nin, person.nin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nin);
    }
}

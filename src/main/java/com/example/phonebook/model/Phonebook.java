package com.example.phonebook.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phonebook {

    @Id
    private String name;
    private String number;

    public Phonebook() {
    }

    public Phonebook(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

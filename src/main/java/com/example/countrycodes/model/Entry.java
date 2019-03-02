package com.example.countrycodes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entry {

    @Id
    private String country;
    private String code;

    public Entry(String country, String code) {
        this.country = country;
        this.code = code;
    }

    public Entry() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "country='" + country + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

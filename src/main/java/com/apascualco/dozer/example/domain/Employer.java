package com.apascualco.dozer.example.domain;

import java.time.LocalDate;

public class Employer {

    private String employerID;

    private String name;
    private String surname;
    private LocalDate birthday;
    private City city;

    private String compositeName;
    private int yeas;

    public String getEmployerID() {
        return employerID;
    }

    public void setEmployerID(String employerID) {
        this.employerID = employerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCompositeName() {
        return compositeName;
    }

    public void setCompositeName(String compositeName) {
        this.compositeName = compositeName;
    }

    public int getYeas() {
        return yeas;
    }

    public void setYeas(int yeas) {
        this.yeas = yeas;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

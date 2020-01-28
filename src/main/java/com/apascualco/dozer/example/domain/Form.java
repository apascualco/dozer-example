package com.apascualco.dozer.example.domain;

import org.dozer.Mapping;

import java.time.LocalDate;

public class Form {

    private String name;
    private String surname;
    private LocalDate birthday;

    private String cityName;
    private String conuntryName;

    @Mapping("employerID")
    private String identificationNumber;

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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getConuntryName() {
        return conuntryName;
    }

    public void setConuntryName(String conuntryName) {
        this.conuntryName = conuntryName;
    }
}

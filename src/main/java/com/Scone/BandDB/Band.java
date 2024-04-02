package com.Scone.BandDB;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Band {
    @Id
    @GeneratedValue
    private long id;

    private String bandName;
    private int yearFormed;

    public Band(){

    }

    public Band(Long id, String bandName, int yearFormed){
        this.id = id;
        this.bandName = bandName;
        this.yearFormed = yearFormed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getYearFormed() {
        return yearFormed;
    }

    public void setYearFormed(int yearFormed) {
        this.yearFormed = yearFormed;
    }
}

package com.Scone.BandDB;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Band {
    @Id
    @GeneratedValue
    private long id;

    private String bandName;
    private int yearFormed;

    private List<Musician> members;

    public Band(){

    }

    public Band(Long id, String bandName, int yearFormed, List<Musician> members){
        this.id = id;
        this.bandName = bandName;
        this.yearFormed = yearFormed;
        this.members = members;
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

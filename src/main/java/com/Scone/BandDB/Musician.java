package com.Scone.BandDB;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Musician {
    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @OneToMany
    private Band band;

    private String firstName;
    private String lastName;
    private String instrument;

    public Musician(){

    }


}

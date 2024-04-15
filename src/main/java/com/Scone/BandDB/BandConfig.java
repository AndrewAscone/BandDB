package com.Scone.BandDB;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BandConfig {
    @Autowired
    private BandRepository bandRepository;
    @Autowired
    private MusicianRepository musicianRepository;

    @PostConstruct
    public void setup(){
        Musician musician1 = new Musician();
    }
}

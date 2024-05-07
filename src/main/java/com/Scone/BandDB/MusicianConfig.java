package com.Scone.BandDB;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MusicianConfig {
    @Autowired
    private MusicianRepository musicianRepository;

    @PostConstruct
    public void setup(){
        Musician musician1 = new Musician();
        musician1.setFirstName("Trey");
        musician1.setLastName("Anastasio");
        musician1.setInstrument("Guitar");

        Musician musician2 = new Musician();
        musician2.setFirstName("Mike");
        musician2.setLastName("Gordon");
        musician2.setInstrument("Bass");

        Musician musician3 = new Musician();
        musician3.setFirstName("Page");
        musician3.setLastName("McConnell");
        musician3.setInstrument("Keys");

        Musician musician4 = new Musician();
        musician4.setFirstName("Jon");
        musician4.setLastName("Fishman");
        musician4.setInstrument("Drums");

        Musician musician5 = new Musician();
        musician4.setFirstName("Tomas");
        musician4.setLastName("Kalnoky");
        musician4.setInstrument("Guitar");

        Musician musician6 = new Musician();
        musician4.setFirstName("Chris");
        musician4.setLastName("Thatcher");
        musician4.setInstrument("Drums");

        Musician musician7 = new Musician();
        musician4.setFirstName("Mike");
        musician4.setLastName("Brown");
        musician4.setInstrument("Saxophone");

        Musician musician8 = new Musician();
        musician4.setFirstName("Pete");
        musician4.setLastName("McCullough");
        musician4.setInstrument("Bass");

        Musician musician9 = new Musician();
        musician4.setFirstName("Karl");
        musician4.setLastName("Lyden");
        musician4.setInstrument("Trombone");

        Musician musician10 = new Musician();
        musician4.setFirstName("Dan");
        musician4.setLastName("Ross");
        musician4.setInstrument("Saxophone");

        Musician musician11 = new Musician();
        musician4.setFirstName("Mike");
        musician4.setLastName("Soprano");
        musician4.setInstrument("Trumpet");

        musicianRepository.saveAll(Arrays.asList(musician1, musician2, musician3, musician4,
                musician5, musician6, musician7, musician8, musician9, musician10, musician11));
    }
}

package com.Scone.BandDB;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Configuration
public class ArtistConfig {
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
        musician5.setFirstName("Tomas");
        musician5.setLastName("Kalnoky");
        musician5.setInstrument("Guitar");

        Musician musician6 = new Musician();
        musician6.setFirstName("Chris");
        musician6.setLastName("Thatcher");
        musician6.setInstrument("Drums");

        Musician musician7 = new Musician();
        musician7.setFirstName("Mike");
        musician7.setLastName("Brown");
        musician7.setInstrument("Saxophone");

        Musician musician8 = new Musician();
        musician8.setFirstName("Pete");
        musician8.setLastName("McCullough");
        musician8.setInstrument("Bass");

        Musician musician9 = new Musician();
        musician9.setFirstName("Karl");
        musician9.setLastName("Lyden");
        musician9.setInstrument("Trombone");

        Musician musician10 = new Musician();
        musician10.setFirstName("Dan");
        musician10.setLastName("Ross");
        musician10.setInstrument("Saxophone");

        Musician musician11 = new Musician();
        musician11.setFirstName("Mike");
        musician11.setLastName("Soprano");
        musician11.setInstrument("Trumpet");

        musicianRepository.saveAll(Arrays.asList(musician1, musician2, musician3, musician4,
                musician5, musician6, musician7, musician8, musician9, musician10, musician11));

        System.out.println("Musician repository has been saved.");
    }
}

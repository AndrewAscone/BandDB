package com.Scone.BandDB;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ArtistConfig {
    @Autowired
    private MusicianService musicianService;

    @PostConstruct
    public void setup() throws IOException {
/*        Musician musician1 = new Musician();
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


        musicianService.saveAll(Arrays.asList(musician1, musician2, musician3, musician4,
                musician5, musician6, musician7, musician8, musician9, musician10, musician11));

 */
        //Step 1: Retrieve musician.json file
        File file = new ClassPathResource("seed-data/musician.json").getFile();
        //Step 2: Parse json as list of musicians
        Musician[] musicianArray = new ObjectMapper().readValue(file, Musician[].class);
        //Step 3: Save musicians to database
        musicianService.saveAll(Arrays.asList(musicianArray));

        System.out.println("Musician repository has been saved.");
    }
}

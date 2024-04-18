package com.Scone.BandDB;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class BandConfig {
    @Autowired
    private BandRepository bandRepository;
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

        musicianRepository.saveAll(Arrays.asList(musician1, musician2, musician3, musician4));

        List<Musician> firstBandMembers = new ArrayList<>();
        firstBandMembers.add(musician1);
        firstBandMembers.add(musician2);
        firstBandMembers.add(musician3);
        firstBandMembers.add(musician4);

        Band band1 = new Band();
        band1.setBandName("Phish");
        band1.setYearFormed(1983);
        band1.setMembers(firstBandMembers);

        bandRepository.save(band1);
    }
}

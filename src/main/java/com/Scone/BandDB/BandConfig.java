package com.Scone.BandDB;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
@Order(2)
public class BandConfig implements Ordered {
    @Autowired
    private BandRepository bandRepository;
 //   @Autowired
//    private MusicianRepository musicianRepository; //Should be service injected, not repository
    @Autowired
    private MusicianService musicianService;

    @PostConstruct
    public void setup(){ //TODO: Break out Musician construction to separate Musician Config
//        Musician musician1 = new Musician();
//        musician1.setFirstName("Trey");
//        musician1.setLastName("Anastasio");
//        musician1.setInstrument("Guitar");
//
//        Musician musician2 = new Musician();
//        musician2.setFirstName("Mike");
//        musician2.setLastName("Gordon");
//        musician2.setInstrument("Bass");
//
//        Musician musician3 = new Musician();
//        musician3.setFirstName("Page");
//        musician3.setLastName("McConnell");
//        musician3.setInstrument("Keys");
//
//        Musician musician4 = new Musician();
//        musician4.setFirstName("Jon");
//        musician4.setLastName("Fishman");
//        musician4.setInstrument("Drums");
//
//        Musician musician5 = new Musician();
//        musician5.setFirstName("Tomas");
//        musician5.setLastName("Kalnoky");
//        musician5.setInstrument("Guitar");
//
//        Musician musician6 = new Musician();
//        musician6.setFirstName("Chris");
//        musician6.setLastName("Thatcher");
//        musician6.setInstrument("Drums");
//
//        Musician musician7 = new Musician();
//        musician7.setFirstName("Mike");
//        musician7.setLastName("Brown");
//        musician7.setInstrument("Saxophone");
//
//        Musician musician8 = new Musician();
//        musician8.setFirstName("Pete");
//        musician8.setLastName("McCullough");
//        musician8.setInstrument("Bass");
//
//        Musician musician9 = new Musician();
//        musician9.setFirstName("Karl");
//        musician9.setLastName("Lyden");
//        musician9.setInstrument("Trombone");
//
//        Musician musician10 = new Musician();
//        musician10.setFirstName("Dan");
//        musician10.setLastName("Ross");
//        musician10.setInstrument("Saxophone");
//
//        Musician musician11 = new Musician();
//        musician11.setFirstName("Mike");
//        musician11.setLastName("Soprano");
//        musician11.setInstrument("Trumpet");

//        musicianRepository.saveAll(Arrays.asList(musician1, musician2, musician3, musician4,
//                musician5, musician6, musician7, musician8, musician9, musician10, musician11));

        List<Musician> musicianList = musicianService.readAll();

        List<Musician> phishBandMembers = musicianList.subList(0,3);
//        phishBandMembers.add(musicianList.get(0));
//        phishBandMembers.add(musicianList.get(1));
//        phishBandMembers.add(musicianList.get(2));
//        phishBandMembers.add(musicianList.get(3));

        List<Musician> streetlightBandMembers = musicianList.subList(4,11);
//        streetlightBandMembers.add(musicianList.get(4));
//        streetlightBandMembers.add(musicianList.get(5));
//        streetlightBandMembers.add(musicianList.get(6));
//        streetlightBandMembers.add(musicianList.get(7));
//        streetlightBandMembers.add(musicianList.get(8));
//        streetlightBandMembers.add(musicianList.get(9));
//        streetlightBandMembers.add(musicianList.get(10));
//        streetlightBandMembers.add(musicianList.get(11));

        Band band1 = new Band("Phish", 1983, phishBandMembers);

        Band band2 = new Band("Streetlight Manifesto", 2002, streetlightBandMembers);

        bandRepository.saveAll(Arrays.asList(band1, band2));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}

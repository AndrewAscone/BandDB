package com.Scone.BandDB;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class BandConfig {
    @Autowired
    private BandService bandService;

    @Autowired
    private MusicianService musicianService;

    @PostConstruct
    public void setup(){

        System.out.println("Hello from Band Config");
        List<Musician> musicianList = musicianService.readAll();
        System.out.println(musicianList);

        List<Musician> phishBandMembers = musicianList.subList(0,4);

        List<Musician> streetlightBandMembers = musicianList.subList(4,11);

        Band band1 = new Band("Phish", 1983, phishBandMembers);

        Band band2 = new Band("Streetlight Manifesto", 2002, streetlightBandMembers);

        bandService.create(band1);
        bandService.create(band2);

        System.out.println("Bands have been saved to repository");
    }
}

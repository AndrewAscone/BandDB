package com.Scone.BandDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicianService {
    private MusicianRepository musicianRepository;

    @Autowired
    public MusicianService(MusicianRepository musicianRepository){
        this.musicianRepository = musicianRepository;
    }
}

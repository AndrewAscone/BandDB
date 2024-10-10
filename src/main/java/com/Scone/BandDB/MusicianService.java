package com.Scone.BandDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicianService {
    private final MusicianRepository musicianRepository;

    @Autowired
    public MusicianService(MusicianRepository musicianRepository){
        this.musicianRepository = musicianRepository;
    }

    public Musician create(Musician musician){
        return musicianRepository.save(musician);
    }

    public Musician readById(Long id){
        return musicianRepository.findById(id).get();
    }

    //TODO: Implement search by musician name (first name? last name? both?)
    public List<Musician> readByLastName(String lastName){
        Iterable<Musician> allMusicians = musicianRepository.findAll();
        List<Musician> requestedList = new ArrayList<>();
        for(Musician musician : allMusicians){
            if(musician.getLastName().equals(lastName)){
                requestedList.add(musician);
            }
        }
        return requestedList;
    }

    public List<Musician> readByFirstName(String firstName){
        Iterable<Musician> allMusicians = musicianRepository.findAll();
        List<Musician> requestedList = new ArrayList<>();
        for(Musician musician : allMusicians){
            if(musician.getFirstName().equals(firstName)){
                requestedList.add(musician);
            }
        }
        return requestedList;
    }

    public Musician readByFirstAndLastName(String firstName, String lastName){
        Iterable<Musician> allMusicians = musicianRepository.findAll();
        Musician requestedMusician = new Musician();
        for(Musician musician : allMusicians){
            if(musician.getFirstName().equals(firstName) && musician.getLastName().equals(lastName)){
                requestedMusician = musician;
            }
        }
        return requestedMusician;
    }



    public List<Musician> readAll(){
        Iterable<Musician> allMusicians = musicianRepository.findAll();
        List<Musician> musicianList = new ArrayList<>();
        allMusicians.forEach(musicianList::add);
        return musicianList;
    }

    public Musician update(Long id, Musician newMusicianData){
        Musician musicianInDatabase = this.readById(id);
        musicianInDatabase.setFirstName(newMusicianData.getFirstName());
        musicianInDatabase.setLastName(newMusicianData.getLastName());
        musicianInDatabase.setInstrument(newMusicianData.getInstrument());
        musicianInDatabase = musicianRepository.save(musicianInDatabase);
        return musicianInDatabase;
    }

    public Musician deleteById(Long id){
        Musician musicianToBeDeleted = this.readById(id);
        musicianRepository.delete(musicianToBeDeleted);
        return musicianToBeDeleted;
    }

    //TODO: Add function to delete musician by name?
    public Musician deleteByName(String firstName, String lastName){
        Musician musicianToBeDeleted = this.readByFirstAndLastName(firstName, lastName);
        musicianRepository.delete(musicianToBeDeleted);
        return musicianToBeDeleted;
    }

    public boolean musicianInDatabase(Musician musician){
        return false;
    }
}

/*
Possible functions to add:
-----------------------------
* boolean musicianInDatabase(Musician musician)
 */
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

    public boolean isMusicianInDatabase(Musician musicianToCheck){
        Iterable<Musician> allMusicians = new ArrayList<>();
        for (Musician nextMusician : allMusicians) {
            boolean musicianFirstNameMatch = nextMusician.getFirstName().equals(musicianToCheck.getFirstName());
            boolean musicianLastNameMatch = nextMusician.getLastName().equals(musicianToCheck.getLastName());
            boolean musicianInstrumentMatch = nextMusician.getInstrument().equals(musicianToCheck.getInstrument());
            if(musicianFirstNameMatch && musicianLastNameMatch && musicianInstrumentMatch){
                return true;
            }
        }
        return false;

        //Check if musician's first name, last name, and instrument match an entry in the database
        //Can't check by id, newly entered musician wouldn't be assigned the same id as previous entry

        //return musicianRepository.existsById(musicianToCheck.getId());
    }

    public List<Musician> saveAll(List<Musician> asList) {
        musicianRepository.saveAll(asList);
        return asList;
    }
}

/*
Extra thoughts
----------------
Do I need a means of adding a newly created musician to a band from here? Or should it be
handled in the band service? I think I might need to create that addMusicianToBand function
in the band service in order to properly connect a musician to a band when a new band is created.
Maybe adding a musician to a band can be achieved by passing a band to have members added and a list
of musicians to add to the band.
 */

/*
Functions to add
------------------

 */
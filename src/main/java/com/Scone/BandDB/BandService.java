package com.Scone.BandDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandService {
    private final BandRepository bandRepository;
    @Autowired
    private MusicianService musicianService;

    @Autowired
    public BandService(BandRepository bandRepository){
        this.bandRepository = bandRepository;
    }

    //When checking if a musician is in the database:
    //If a musician IS in the database already
    //Should I change the musician's ID to match/reference the musician already in the DB?
    public Band create(Band band){
//        for(Musician musician : band.getMembers()){
//            if(!musicianService.isMusicianInDatabase(musician)){
//                musicianService.create(musician);
//            }
//        }

        band
                .getMembers()
                .stream()
                .filter(musician -> !musicianService.isMusicianInDatabase(musician))
                .forEach(musician -> musicianService.create(musician));
        return bandRepository.save(band);
    }

    public Band readById(Long id){
        return bandRepository.findById(id).get();
    }

    public Band readByName(String bandToFind){
        Iterable<Band> allBands = bandRepository.findAll();
        for (Band band: allBands){
            if(band.getBandName().equals(bandToFind)){
                return band;
            }
        }
        return null;
    }

    public List<Band> readAll(){
        Iterable<Band> allBands = bandRepository.findAll();
        List<Band> bandList = new ArrayList<>();
        allBands.forEach(bandList::add);
        return bandList;
    }

    public Band update(Long id, Band newBandData){
        Band bandInDatabase = this.readById(id);
        bandInDatabase.setBandName(newBandData.getBandName());
        bandInDatabase.setYearFormed(newBandData.getYearFormed());
        bandInDatabase.setMembers(newBandData.getMembers());
        bandInDatabase = bandRepository.save(bandInDatabase);
        return bandInDatabase;
    }

    public Band deleteById(Long id){
        Band bandToBeDeleted = this.readById(id);
        bandRepository.delete(bandToBeDeleted);
        return bandToBeDeleted;
    }

    //TODO: Add function to delete band by name?
    public Band deleteByName(String bandName){
        Band bandToBeDeleted = this.readByName(bandName);
        bandRepository.delete(bandToBeDeleted);
        return bandToBeDeleted;
    }

    public Band addMusicianToBand(Long id, Musician musicianToAdd){
        Band bandInDatabase = this.readById(id);
        List<Musician> musiciansInBand = bandInDatabase.getMembers();
        musiciansInBand.add(musicianToAdd);
        bandInDatabase.setMembers(musiciansInBand);
        bandInDatabase = bandRepository.save(bandInDatabase);
        return bandInDatabase;
    }
}

/*
Extra thoughts:
-----------------
Do I need to have the Musician Repo or the Musician Service here as well? Whenever I make a band,
I should check through the musician list in the newly created band. If the musician is a match for one
in the existing repo, then I need to connect their id with the id of the band. If not, I need to create
them in the musician repository so they can be connected to the new band. On the other side of things,
I need to be able to connect existing musicians to a new band or bands somehow (but maybe that's trying
to do too much for now?)(maybe that would be a function to add to the musician service).
 */

/*
Possible functions to add:
---------------------------

 */
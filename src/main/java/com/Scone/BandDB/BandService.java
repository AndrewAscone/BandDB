package com.Scone.BandDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BandService {
    private BandRepository bandRepository;

    @Autowired
    public BandService(BandRepository bandRepository){
        this.bandRepository = bandRepository;
    }

    public Band create(Band band){
        return bandRepository.save(band);
    }

    public Band readById(Long id){
        return bandRepository.findById(id).get();
    }

    public Band readByName(String bandName){ //TODO: Implement search by band name
        Iterable<Band> allBands = bandRepository.findAll();
        for (Band band: allBands){
            if(band.getBandName().equals(bandName)){
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

    public Band update(Long id, Band newBandData){ //TODO: Implement band update
        return null;
    }

    public Band deleteById(Long id){
        Band bandToBeDeleted = this.readById(id);
        bandRepository.delete(bandToBeDeleted);
        return bandToBeDeleted;
    }

    //TODO: Add function to delete band by name?
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

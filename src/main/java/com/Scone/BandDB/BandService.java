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

    public Band readByName(String name){ //TODO: Implement search by band name
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

package com.Scone.BandDB;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MusicianController {
    private final MusicianService musicianService;

    @Autowired
    public MusicianController(MusicianService musicianService){
        this.musicianService = musicianService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Musician> create(@RequestBody Musician musician){
        return new ResponseEntity<>(musicianService.create(musician), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Musician> readById(@PathVariable Long id){
        return new ResponseEntity<>(musicianService.readById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readFirstName/{firstName}")
    public ResponseEntity<List<Musician>> readByFirstName(@PathVariable String firstName){
        return new ResponseEntity<>(musicianService.readByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping(value = "/readLastName/{lastName}")
    public ResponseEntity<List<Musician>> readByLastName(@PathVariable String lastName){
        return new ResponseEntity<>(musicianService.readByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping(value = "/readFirstLastName/{firstName}+{lastName}") //TODO: Fix these path variables
    public ResponseEntity<Musician> readByFirstAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return new ResponseEntity<>(musicianService.readByFirstAndLastName(firstName, lastName), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<List<Musician>> readAll(){
        return new ResponseEntity<>(musicianService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Musician> updateById(@PathVariable Long id, @RequestBody Musician newData){
        return new ResponseEntity<>(musicianService.update(id, newData), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Musician> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(musicianService.deleteById(id), HttpStatus.OK);
    }
}

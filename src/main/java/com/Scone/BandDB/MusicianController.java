package com.Scone.BandDB;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}

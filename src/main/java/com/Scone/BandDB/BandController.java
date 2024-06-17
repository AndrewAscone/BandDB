package com.Scone.BandDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/band")
public class BandController {

    private final BandService bandService;

    @Autowired
    public BandController(BandService bandService){
        this.bandService = bandService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Band> create(@RequestBody Band band){
        return new ResponseEntity<>(bandService.create(band), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Band> readById(@PathVariable Long id){
        return new ResponseEntity<>(bandService.readById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<List<Band>> readAll(){
        return new ResponseEntity<>(bandService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Band> updateById(@PathVariable Long id, @RequestBody Band newData){
        return new ResponseEntity<>(bandService.update(id, newData), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Band> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(bandService.deleteById(id), HttpStatus.OK);
    }
}

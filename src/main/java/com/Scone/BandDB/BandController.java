package com.Scone.BandDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

package com.example.codeclan.pirateservice.controllers;


import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repositories.PiratesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {

    @Autowired
    PiratesRepository piratesRepository;

    @GetMapping(value ="/pirates")
    public List<Pirate> getAllPirates(){
        return piratesRepository.findAll();
    }

    @GetMapping(value="/pirates/{id}")
    public Optional<Pirate> getPirate(@PathVariable Long id){ //reason why using optional is to return both a pirate and null if there is none
        return piratesRepository.findById(id);
    }



}

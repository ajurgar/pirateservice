package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PiratesRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PiratesRepository piratesRepository; //behaves as an intance of the interface to access methods


	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createPirateAndShip(){
		Ship ship = new Ship("The black pearl");
		shipRepository.save(ship);
		Raid raid = new Raid("Rawraiding Oddbins", 3000);
		raidRepository.save(raid);
		Pirate pirate = new Pirate("Jack", "Sparrow", 32, ship);
		pirate.addRaid(raid);
		piratesRepository.save(pirate);
	}





}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Klijent;
import com.example.demo.model.RacuniPravnihLica;
import com.example.demo.service.RacuniPravnihLicaService;

@RestController
@RequestMapping(value = "/racuni")
public class RacuniPravnihLicaController {

	@Autowired
	private RacuniPravnihLicaService racuniPravnihLicaService;
	
	@RequestMapping(value="/getRacuni", method=RequestMethod.GET)
	public ResponseEntity<List<RacuniPravnihLica>> getRacuni(){
		List<RacuniPravnihLica> racuni = racuniPravnihLicaService.findAll();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/dodajRacun", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RacuniPravnihLica> dodajKlijenta(@RequestBody RacuniPravnihLica racun){
		System.out.println("TO STRING -- " + racun.toString());
		RacuniPravnihLica r = new RacuniPravnihLica(racun.getIdRacuna(), racun.getBrojRacuna(), racun.getDatumOtvaranja(),
				true, racun.getValute(), racun.getKlijent());
		racuniPravnihLicaService.save(r);
		return new ResponseEntity<>(r, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RacuniPravnihLica> deaktiviraj(@PathVariable Long id) {
		RacuniPravnihLica deaktiviran = racuniPravnihLicaService.findOne(id);
		deaktiviran.setVazeci(false);
		racuniPravnihLicaService.save(deaktiviran);
	 return new ResponseEntity<>(deaktiviran, HttpStatus.OK);
	}
}

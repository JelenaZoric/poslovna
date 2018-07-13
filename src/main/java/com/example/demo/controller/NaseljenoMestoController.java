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

import com.example.demo.model.Drzava;
import com.example.demo.model.NaseljenoMesto;
import com.example.demo.model.dto.NaseljenoMestoDTO;
import com.example.demo.service.DrzavaService;
import com.example.demo.service.NaseljenoMestoService;

@RestController
@RequestMapping(value = "/naseljenaMesta")
public class NaseljenoMestoController {

	@Autowired
	private NaseljenoMestoService naseljenoMestoService;
	
	@Autowired
	private DrzavaService drzavaService;
	
	@RequestMapping(value="/getNaseljenaMesta", method=RequestMethod.GET)
	public ResponseEntity<List<NaseljenoMesto>> getNaseljenaMesta(){
		List<NaseljenoMesto> naseljenaMesta = naseljenoMestoService.findAll();
		return new ResponseEntity<>(naseljenaMesta, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getNaseljenoMesto/{id}", method = RequestMethod.GET)
	public ResponseEntity<NaseljenoMesto> getNaseljenoMesto(@PathVariable Long id){
		NaseljenoMesto naseljenoMesto = naseljenoMestoService.findOne(id);
		return new ResponseEntity<>(naseljenoMesto, HttpStatus.OK);
	}
	@RequestMapping(value="/dodajNaseljenoMesto/{id}", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NaseljenoMesto> dodajNaseljenoMesto(@RequestBody NaseljenoMestoDTO naseljenoMesto, @PathVariable Long id){
		System.out.println("PTT oznaka " + naseljenoMesto.getpTToznaka());
		System.out.println("naziv       "   + naseljenoMesto.getNaziv());
		System.out.println("sifra       "   + naseljenoMesto.getSifraMesta());
		System.out.println("id      "   + naseljenoMesto.getDrzava());
		Drzava d = drzavaService.findOne(id);
	//	Long i = (long) 1;
	//	Drzava d = drzavaService.findOne(i);
		NaseljenoMesto nm = new NaseljenoMesto(naseljenoMesto.getSifraMesta(), naseljenoMesto.getNaziv(), naseljenoMesto.getpTToznaka(), d);
		naseljenoMestoService.save(nm);
		return new ResponseEntity<>(nm, HttpStatus.OK);		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<NaseljenoMesto> obrisiNaseljenoMesto(@PathVariable Long id) {
		NaseljenoMesto naseljenoMesto = naseljenoMestoService.delete(id);
	 return new ResponseEntity<>(naseljenoMesto, HttpStatus.OK);
	}
}

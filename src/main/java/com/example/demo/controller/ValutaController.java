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
import com.example.demo.model.ValutaDTO;
import com.example.demo.model.Valute;
import com.example.demo.service.DrzavaService;
import com.example.demo.service.ValuteService;

@RestController
@RequestMapping(value = "/valute")
public class ValutaController {

	@Autowired
	private ValuteService valuteService;
	
	@Autowired
	private DrzavaService drzavaService;
	
	@RequestMapping(value="/getValute", method=RequestMethod.GET)
	public ResponseEntity<List<Valute>> getValute(){
		List<Valute> valute = valuteService.findAll();
		return new ResponseEntity<>(valute, HttpStatus.OK);		
	}
	@RequestMapping(value="/getValutu/{id}", method = RequestMethod.GET)
	public ResponseEntity<Valute> getValutu(@PathVariable Long id){
	    Valute v = valuteService.findOne(id);
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	@RequestMapping(value="/dodajValutu", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Valute> dodajValutu(@RequestBody ValutaDTO valuta){
		Drzava d = drzavaService.findOne(valuta.getDrzava());
		Valute v = new Valute(valuta.getZvanicnaSifra(), valuta.getNaziv(), valuta.isDomicilna(), d);
		valuteService.save(v);
		return new ResponseEntity<>(v, HttpStatus.OK);		
	}
	@RequestMapping(value="/izmeniValutu/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Valute> izmeniValutu(@RequestBody ValutaDTO valuta, @PathVariable Long id){
		Drzava d = drzavaService.findOne(valuta.getDrzava());
		Valute edit = new Valute(valuta.getZvanicnaSifra(), valuta.getNaziv(), valuta.isDomicilna(), d);
	    Valute v = valuteService.findOne(id);
	    v.setZvanicnaSifra(edit.getZvanicnaSifra());
	    v.setNaziv(edit.getNaziv());
	    v.setDomicilna(edit.isDomicilna());
	    v.setDrzava(edit.getDrzava());
		valuteService.save(v);
		return new ResponseEntity<>(v, HttpStatus.OK);		
	}
	
	//prilikom brisanja valute brisu se i svi racuni koji su u toj valuti
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Valute> obrisiValutu(@PathVariable Long id) {
		Valute valuta = valuteService.delete(id);
	 return new ResponseEntity<>(valuta, HttpStatus.OK);
	}
}

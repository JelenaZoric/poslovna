package com.example.demo.controller;

import java.util.List;
import java.util.Set;

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
import com.example.demo.model.Klijent;
import com.example.demo.model.RacunDTO;
import com.example.demo.model.RacuniPravnihLica;
import com.example.demo.model.ValutaDTO;
import com.example.demo.model.Valute;
import com.example.demo.service.DrzavaService;
import com.example.demo.service.RacuniPravnihLicaService;
import com.example.demo.service.ValuteService;

@RestController
@RequestMapping(value = "/valute")
public class ValutaController {

	@Autowired
	private ValuteService valuteService;
	
	@Autowired
	private RacuniPravnihLicaService racuniPravnihLicaService;
	
	@Autowired
	private DrzavaService drzavaService;
	
	@RequestMapping(value="/getValute", method=RequestMethod.GET)
	public ResponseEntity<List<Valute>> getValute(){
		List<Valute> valute = valuteService.findAll();
		return new ResponseEntity<>(valute, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/dodajValutu", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Valute> dodajValutu(@RequestBody ValutaDTO valuta){
		Drzava d = drzavaService.findOne(valuta.getDrzava());
		Valute v = new Valute(valuta.getZvanicnaSifra(), valuta.getNaziv(), valuta.isDomicilna(), d);
		valuteService.save(v);
		return new ResponseEntity<>(v, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Valute> obrisiValutu(@PathVariable Long id) {
		Valute valuta = valuteService.findOne(id);
		Set<RacuniPravnihLica> racuni = valuta.getListaRacunaPravnihLica();
		for(RacuniPravnihLica r : racuni) {
			r.setVazeci(false);
			racuniPravnihLicaService.save(r);
		}
		Valute v = valuteService.delete(id);
	 return new ResponseEntity<>(v, HttpStatus.OK);
	}
}

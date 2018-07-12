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

import com.example.demo.model.Banka;
import com.example.demo.model.Klijent;
import com.example.demo.model.RacunDTO;
import com.example.demo.model.RacuniPravnihLica;
import com.example.demo.model.Valute;
import com.example.demo.service.BankaService;
import com.example.demo.service.KlijentService;
import com.example.demo.service.RacuniPravnihLicaService;
import com.example.demo.service.ValuteService;

@RestController
@RequestMapping(value = "/racuni")
public class RacuniPravnihLicaController {

	@Autowired
	private RacuniPravnihLicaService racuniPravnihLicaService;
	
	@Autowired
	private KlijentService klijentService;
	
	@Autowired
	private ValuteService valuteService;
	
	@Autowired
	private BankaService bankaService;
	
	@RequestMapping(value="/getRacuni", method=RequestMethod.GET)
	public ResponseEntity<List<RacuniPravnihLica>> getRacuni(){
		List<RacuniPravnihLica> racuni = racuniPravnihLicaService.findAll();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getRacun/{id}", method = RequestMethod.GET)
	public ResponseEntity<RacuniPravnihLica> getRacun(@PathVariable Long id){
	    RacuniPravnihLica r = racuniPravnihLicaService.findOne(id);
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
	
	//za next iz tabele klijenata
	@RequestMapping(value="/getRacuni/{id}", method=RequestMethod.GET)
	public ResponseEntity<Set<RacuniPravnihLica>> getRacuniNext(@PathVariable Long id){
		Klijent k = klijentService.findOne(id);
		Set<RacuniPravnihLica> racuni = k.getListaRacunaPravnihLica();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
	
	//za next iz tabele valuta
	@RequestMapping(value="/getRacuni2/{id}", method=RequestMethod.GET)
	public ResponseEntity<Set<RacuniPravnihLica>> getRacuniNext2(@PathVariable Long id){
		Valute v = valuteService.findOne(id);
		Set<RacuniPravnihLica> racuni = v.getListaRacunaPravnihLica();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
	
	//za next iz tabele banki
	@RequestMapping(value="/getRacuni3/{id}", method=RequestMethod.GET)
	public ResponseEntity<Set<RacuniPravnihLica>> getRacuniNext3(@PathVariable Long id){
		Banka b = bankaService.findOne(id);
		Set<RacuniPravnihLica> racuni = b.getListaRacunaPravnihLica();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
		
	@RequestMapping(value="/dodajRacun", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RacuniPravnihLica> dodajKlijenta(@RequestBody RacunDTO racun){
		Klijent k = klijentService.findOne(racun.getKlijent());
		Valute v = valuteService.findOne(racun.getValute());
		Banka b = bankaService.findOne(racun.getBanka());
		RacuniPravnihLica r = new RacuniPravnihLica(racun.getBrojRacuna(), 
				racun.getDatumOtvaranja(), true, v, k, b);
		racuniPravnihLicaService.save(r);
		return new ResponseEntity<>(r, HttpStatus.OK);		
	}
	@RequestMapping(value="/izmeniRacun/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RacuniPravnihLica> izmeniRacun(@RequestBody RacunDTO racun, @PathVariable Long id){
        RacuniPravnihLica r = racuniPravnihLicaService.findOne(id);
        Klijent k = klijentService.findOne(r.getKlijent().getId());
        Valute valute = valuteService.findOne(racun.getValute());
        RacuniPravnihLica edit = new RacuniPravnihLica(racun.getBrojRacuna(), 
				racun.getDatumOtvaranja(), valute);
		
		r.setBrojRacuna(edit.getBrojRacuna());
		r.setDatumOtvaranja(edit.getDatumOtvaranja());
		r.setKlijent(k);
		r.setValute(edit.getValute());
		racuniPravnihLicaService.save(r);
		return new ResponseEntity<>(r, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/aktiviraj/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RacuniPravnihLica> aktiviraj(@PathVariable Long id) {
		RacuniPravnihLica aktiviran = racuniPravnihLicaService.findOne(id);
		aktiviran.setVazeci(true);
		racuniPravnihLicaService.save(aktiviran);
	 return new ResponseEntity<>(aktiviran, HttpStatus.OK);
	}
}

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

import com.example.demo.model.Klijent;
import com.example.demo.model.RacuniPravnihLica;
import com.example.demo.service.KlijentService;
import com.example.demo.service.RacuniPravnihLicaService;

@RestController
@RequestMapping(value = "/klijenti")
public class KlijentController {

	@Autowired
	private KlijentService klijentService;
	
	@Autowired
	private RacuniPravnihLicaService racuniPravnihLicaService;
	
	@RequestMapping(value="/getKlijenti", method=RequestMethod.GET)
	public ResponseEntity<List<Klijent>> getKlijenti(){
		List<Klijent> klijenti = klijentService.findAll();
		return new ResponseEntity<>(klijenti, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/dodajKlijenta", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Klijent> dodajKlijenta(@RequestBody Klijent klijent){
		System.out.println("TO STRING -- " + klijent.toString());
		Klijent k = new Klijent(klijent.getIdKlijenta(), klijent.getNazivKlijenta(), klijent.getMesto(), klijent.getAdresa(),
				klijent.getTelefon(), klijent.getFaks(), klijent.getEmail(), klijent.getJmbg(), klijent.getOdgovornoLice(),
				klijent.getNazivDelatnosti(), klijent.getSifraDelatnosti(), klijent.getNadlezniPoreskiOrgan(), klijent.getPoreskiBroj(), true);
		klijentService.save(k);
		return new ResponseEntity<>(k, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getKlijenta/{id}", method = RequestMethod.GET)
	public ResponseEntity<Klijent> getKlijenta(@PathVariable Long id){
		Klijent k = klijentService.findOne(id);
		return new ResponseEntity<>(k, HttpStatus.OK);
	}
	
	@RequestMapping(value="/izmeniKlijenta/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Klijent> izmeniKlijenta(@PathVariable Long id, @RequestBody Klijent klijent) {
		Klijent k = klijentService.findOne(id);
		k.setIdKlijenta(klijent.getIdKlijenta());
		k.setNazivKlijenta(klijent.getNazivKlijenta());
		k.setAdresa(klijent.getAdresa());
		k.setMesto(klijent.getMesto());
		k.setTelefon(klijent.getTelefon());
		k.setFaks(klijent.getFaks());
		k.setEmail(klijent.getEmail());
		k.setJmbg(klijent.getJmbg());
		k.setNadlezniPoreskiOrgan(klijent.getNadlezniPoreskiOrgan());
		k.setNazivDelatnosti(klijent.getNazivDelatnosti());
		k.setSifraDelatnosti(klijent.getSifraDelatnosti());
		k.setPoreskiBroj(klijent.getPoreskiBroj());
		k.setOdgovornoLice(klijent.getOdgovornoLice());
		klijentService.save(k);
		return new ResponseEntity<>(k, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Klijent> deaktiviraj(@PathVariable Long id) {
		Klijent deaktiviran = klijentService.findOne(id);
		Set<RacuniPravnihLica> racuni = deaktiviran.getListaRacunaPravnihLica();
		for(RacuniPravnihLica r : racuni) {
			r.setVazeci(false);
			racuniPravnihLicaService.save(r);
		}
		deaktiviran.setAktivan(false);
		klijentService.save(deaktiviran);
	 return new ResponseEntity<>(deaktiviran, HttpStatus.OK);
	}
	
}

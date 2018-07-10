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
import com.example.demo.service.DrzavaService;

@RestController
@RequestMapping(value = "/drzave")
public class DrzavaController {

	@Autowired
	private DrzavaService drzavaService;
	
	@RequestMapping(value="/getDrzave", method=RequestMethod.GET)
	public ResponseEntity<List<Drzava>> getDrzave(){
		List<Drzava> drzave = drzavaService.findAll();
		return new ResponseEntity<>(drzave, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getDrzava/{id}", method = RequestMethod.GET)
	public ResponseEntity<Drzava> getDrzavu(@PathVariable Long id){
		Drzava d = drzavaService.findOne(id);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	@RequestMapping(value="/dodajDrzavu", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drzava> dodajDrzavu(@RequestBody Drzava drzava){
		Drzava d = new Drzava(drzava.getSifraDrzave(), drzava.getNazivDrzave());
		drzavaService.save(d);
		return new ResponseEntity<>(d, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/izmeniDrzavu/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drzava> izmeniBanka(@RequestBody Drzava drzava, @PathVariable Long id){
		Drzava d = drzavaService.findOne(id);
		System.out.println(d.getNazivDrzave() + " " + d.getSifraDrzave());
		System.out.println(drzava.getNazivDrzave() + " " + drzava.getSifraDrzave());
		d.setNazivDrzave(drzava.getNazivDrzave());
		d.setSifraDrzave(drzava.getSifraDrzave());
		System.out.println(d.getNazivDrzave() + " " + d.getSifraDrzave());
		drzavaService.save(d);
		return new ResponseEntity<>(d, HttpStatus.OK);		
	}
	
	//prilikom brisanja drzave brisu se i sva njeni naseljena mesta
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Drzava> obrisiBanku(@PathVariable Long id) {
		Drzava d = drzavaService.delete(id);
	 return new ResponseEntity<>(d, HttpStatus.OK);
	}
}

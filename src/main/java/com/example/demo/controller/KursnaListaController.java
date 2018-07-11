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

import com.example.demo.model.Banka;
import com.example.demo.model.Drzava;
import com.example.demo.model.KursnaLista;
import com.example.demo.model.KursnaListaDTO;
import com.example.demo.service.BankaService;
import com.example.demo.service.KursnaListaService;

@RestController
@RequestMapping(value = "/kursneListe")
public class KursnaListaController {

	@Autowired
	private KursnaListaService kursnaListaService;
	
	@Autowired
	private BankaService bankaService;
	
	@RequestMapping(value="/getKursneListe", method=RequestMethod.GET)
	public ResponseEntity<List<KursnaLista>> getKursneListe(){
		List<KursnaLista> k = kursnaListaService.findAll();
		return new ResponseEntity<>(k, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getKursnaLista/{id}", method = RequestMethod.GET)
	public ResponseEntity<KursnaLista> getKursnaLista(@PathVariable Long id){
		KursnaLista k = kursnaListaService.findOne(id);
		return new ResponseEntity<>(k, HttpStatus.OK);
	}
	
	@RequestMapping(value="/dodajKursnuListu", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KursnaLista> dodajDrzavu(@RequestBody KursnaListaDTO kl){
		Banka b = bankaService.findOne(kl.getBanka());
		KursnaLista k = new KursnaLista(kl.getIdKursneListe(), kl.getDatum(), kl.getBrojKursneListe(), 
				kl.getPrimenjujeSeOd(), b);
		kursnaListaService.save(k);
		return new ResponseEntity<>(k, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/izmeniKursnuListu/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KursnaLista> izmeniKursnuListu(@RequestBody KursnaListaDTO kl, @PathVariable Long id){
		KursnaLista k = kursnaListaService.findOne(id);
		Banka b = bankaService.findOne(kl.getBanka());
		k.setBanka(b);
		k.setBrojKursneListe(kl.getBrojKursneListe());
		k.setDatum(kl.getDatum());
		k.setIdKursneListe(kl.getIdKursneListe());
		k.setPrimenjujeSeOd(kl.getPrimenjujeSeOd());
		kursnaListaService.save(k);
		return new ResponseEntity<>(k, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<KursnaLista> obrisiKursnuListu(@PathVariable Long id) {
		KursnaLista k = kursnaListaService.delete(id);
	 return new ResponseEntity<>(k, HttpStatus.OK);
	}
}

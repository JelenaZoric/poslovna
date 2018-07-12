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
import com.example.demo.model.KursUValuti;
import com.example.demo.model.KursUValutiDTO;
import com.example.demo.model.KursnaLista;
import com.example.demo.model.Valute;
import com.example.demo.service.KursUValutiService;
import com.example.demo.service.KursnaListaService;
import com.example.demo.service.ValuteService;

@RestController
@RequestMapping(value = "/kurseviUValuti")
public class KursUValutiController {
	
	@Autowired
	private KursUValutiService kursUValutiService;
	
	@Autowired
	private ValuteService valuteService;
	
	@Autowired
	private KursnaListaService kursnaListaService;

	@RequestMapping(value="/getKurseviUValuti", method=RequestMethod.GET)
	public ResponseEntity<List<KursUValuti>> getKurseviUValuti(){
		List<KursUValuti> kursevi = kursUValutiService.findAll();
		return new ResponseEntity<>(kursevi, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getKursUValuti/{id}", method = RequestMethod.GET)
	public ResponseEntity<KursUValuti> getKursUValuti(@PathVariable Long id){
		KursUValuti k = kursUValutiService.findOne(id);
		return new ResponseEntity<>(k, HttpStatus.OK);
	}
	
	@RequestMapping(value="/dodajKurs", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KursUValuti> dodajKursUValuti(@RequestBody KursUValutiDTO kv){
		Valute osnovna = valuteService.findOne(kv.getValutaOsnovna());
		Valute prema = valuteService.findOne(kv.getValutaPrema());
		KursnaLista lista = kursnaListaService.findOne(kv.getKursnaLista());
		KursUValuti k = new KursUValuti(kv.getRedniBroj(), kv.getKupovni(), kv.getSrednji(), kv.getProdajni(),
				osnovna, prema, lista);
		kursUValutiService.save(k);
		return new ResponseEntity<>(k, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/izmeniKurs/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KursUValuti> izmeniKurs(@RequestBody KursUValutiDTO kv, @PathVariable Long id){
		Valute osnovna = valuteService.findOne(kv.getValutaOsnovna());
		Valute prema = valuteService.findOne(kv.getValutaPrema());
		KursnaLista lista = kursnaListaService.findOne(kv.getKursnaLista());
		KursUValuti k = kursUValutiService.findOne(id);
		k.setRedniBroj(kv.getRedniBroj());
		k.setKupovni(kv.getKupovni());
		k.setSrednji(kv.getSrednji());
		k.setProdajni(kv.getProdajni());
		k.setValutaOsnovna(osnovna);
		k.setValutaPrema(prema);
		k.setKursnaLista(lista);
		kursUValutiService.save(k);
	return new ResponseEntity<>(k, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<KursUValuti> obrisiKursUValuti(@PathVariable Long id) {
		KursUValuti k = kursUValutiService.delete(id);
	return new ResponseEntity<>(k, HttpStatus.OK);
	}
}

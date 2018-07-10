package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Valute;
import com.example.demo.service.ValuteService;

@RestController
@RequestMapping(value = "/valute")
public class ValutaController {

	@Autowired
	private ValuteService valuteService;
	
	@RequestMapping(value="/getValute", method=RequestMethod.GET)
	public ResponseEntity<List<Valute>> getValute(){
		List<Valute> valute = valuteService.findAll();
		return new ResponseEntity<>(valute, HttpStatus.OK);		
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}

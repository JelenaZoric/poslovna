package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Valute;

public interface ValuteService {
	Valute save(Valute valute);
	
	List<Valute> findAll();
	
	Valute findOne(Long id);
}

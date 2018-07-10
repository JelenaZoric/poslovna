package com.example.demo.service;

import com.example.demo.model.AnalitikaIzvoda;

public interface AnalitikaIzvodaService {

	AnalitikaIzvoda save(AnalitikaIzvoda analitikaIzvoda);
	
	AnalitikaIzvoda findOne(Long id);
}

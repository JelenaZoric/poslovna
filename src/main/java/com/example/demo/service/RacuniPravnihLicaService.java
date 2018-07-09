package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RacuniPravnihLica;

public interface RacuniPravnihLicaService {
	RacuniPravnihLica save(RacuniPravnihLica racuni);
	
	RacuniPravnihLica findOne(Long id);
	
	List<RacuniPravnihLica> findAll();
}

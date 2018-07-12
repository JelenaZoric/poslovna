package com.example.demo.service;

import java.util.List;

import com.example.demo.model.NaseljenoMesto;

public interface NaseljenoMestoService {
	NaseljenoMesto save(NaseljenoMesto naseljenoMesto);
	
    NaseljenoMesto findOne(Long id);
	
	List<NaseljenoMesto> findAll();
	
	NaseljenoMesto delete(Long id);
}

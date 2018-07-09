package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Klijent;


public interface KlijentService {
	Klijent save(Klijent klijent);
	
	List<Klijent> findAll();
	
	Klijent findOne(Long id);
	
	Klijent delete(Long id);
}

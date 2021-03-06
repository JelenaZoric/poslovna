package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Drzava;

public interface DrzavaService {
	Drzava save(Drzava drzava);
	
	Drzava findOne(Long id);
	
	List<Drzava> findAll();
	
	Drzava delete(Long id);
}

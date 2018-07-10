package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Banka;

public interface BankaService {
	Banka save(Banka banka);
	
	List<Banka> findAll();
	
	Banka findOne(Long id);
	
	Banka delete(Long id);
}

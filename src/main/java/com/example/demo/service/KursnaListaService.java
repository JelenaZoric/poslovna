package com.example.demo.service;

import java.util.List;

import com.example.demo.model.KursnaLista;

public interface KursnaListaService {

	KursnaLista save(KursnaLista kursnaLista);
	
	KursnaLista findOne(Long id);
	
	List<KursnaLista> findAll();
	
	KursnaLista delete(Long id);
}

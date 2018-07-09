package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.AnalitikaIzvoda;
import com.example.demo.repository.AnalitikaIzvodaRepository;

@Transactional
@Service
public class AnalitikaIzvodaServiceImpl implements AnalitikaIzvodaService {

	@Autowired
	private AnalitikaIzvodaRepository analitikaIzvodaRepository;
	
	@Override
	public AnalitikaIzvoda save(AnalitikaIzvoda analitikaIzvoda) {
		return analitikaIzvodaRepository.save(analitikaIzvoda);
	}

}

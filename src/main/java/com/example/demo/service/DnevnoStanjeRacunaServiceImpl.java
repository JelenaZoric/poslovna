package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DnevnoStanjeRacuna;
import com.example.demo.repository.DnevnoStanjeRacunaRepository;

@Transactional
@Service
public class DnevnoStanjeRacunaServiceImpl implements DnevnoStanjeRacunaService {

	@Autowired
	private DnevnoStanjeRacunaRepository dnevnoStanjeRepository;
	
	@Override
	public DnevnoStanjeRacuna save(DnevnoStanjeRacuna dnevnoStanje) {
		return dnevnoStanjeRepository.save(dnevnoStanje);
	}

}

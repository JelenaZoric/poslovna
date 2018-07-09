package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.RacuniPravnihLica;
import com.example.demo.repository.RacuniPravnihLicaRepository;

@Transactional
@Service
public class RacuniPravnihLicaServiceImpl implements RacuniPravnihLicaService {

	@Autowired
	private RacuniPravnihLicaRepository racuniRepository;
	
	@Override
	public RacuniPravnihLica save(RacuniPravnihLica racuni) {
		return racuniRepository.save(racuni);
	}

}

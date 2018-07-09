package com.example.demo.service;

import java.util.List;

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

	@Override
	public RacuniPravnihLica findOne(Long id) {
		return racuniRepository.findById(id).get();
	}

	@Override
	public List<RacuniPravnihLica> findAll() {
		return racuniRepository.findAll();
	}

}

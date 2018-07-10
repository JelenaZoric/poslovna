package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Valute;
import com.example.demo.repository.ValuteRepository;

@Transactional
@Service
public class ValuteServiceImpl implements ValuteService {

	@Autowired
	private ValuteRepository valuteRepository;
	
	@Override
	public Valute save(Valute valute) {
		return valuteRepository.save(valute);
	}

	@Override
	public List<Valute> findAll() {
		return valuteRepository.findAll();
	}

	@Override
	public Valute findOne(Long id) {
		return valuteRepository.findById(id).get();
	}

}

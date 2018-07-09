package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.VrstaPlacanja;
import com.example.demo.repository.VrstaPlacanjaRepository;

@Transactional
@Service
public class VrstaPlacanjaServiceImpl implements VrstaPlacanjaService {

	@Autowired
	private VrstaPlacanjaRepository vrstaPlacanjaRepository;
	
	@Override
	public VrstaPlacanja save(VrstaPlacanja vrstaPlacanja) {
		return vrstaPlacanjaRepository.save(vrstaPlacanja);
	}

}

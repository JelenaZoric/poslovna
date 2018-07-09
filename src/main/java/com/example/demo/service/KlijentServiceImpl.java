package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Klijent;
import com.example.demo.repository.KlijentRepository;

@Transactional
@Service
public class KlijentServiceImpl implements KlijentService {

	@Autowired
	private KlijentRepository klijentRepository;
	
	@Override
	public Klijent save(Klijent klijent) {
		return klijentRepository.save(klijent);
	}

}

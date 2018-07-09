package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Klijent> findAll() {
		return klijentRepository.findAll();
	}

	@Override
	public Klijent findOne(Long id) {
		return klijentRepository.findById(id).get();
	}

	@Override
	public Klijent delete(Long id) {
		Klijent klijent = klijentRepository.findById(id).get();
		if(klijent == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant klijent");
		}
		klijentRepository.delete(klijent);
		return klijent;
	}

}

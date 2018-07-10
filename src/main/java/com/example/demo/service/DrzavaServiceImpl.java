package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Banka;
import com.example.demo.model.Drzava;
import com.example.demo.repository.DrzavaRepository;

@Transactional
@Service
public class DrzavaServiceImpl implements DrzavaService {

	@Autowired
	private DrzavaRepository drzavaRepository;
	
	@Override
	public Drzava save(Drzava drzava) {
		return drzavaRepository.save(drzava);
	}

	@Override
	public Drzava findOne(Long id) {
		return drzavaRepository.findById(id).get();
	}

	@Override
	public List<Drzava> findAll() {
		return drzavaRepository.findAll();
	}

	@Override
	public Drzava delete(Long id) {
		Drzava drzava = drzavaRepository.findById(id).get();
		if(drzava == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant drzava");
		}
		drzavaRepository.delete(drzava);
		return drzava;
	}

}

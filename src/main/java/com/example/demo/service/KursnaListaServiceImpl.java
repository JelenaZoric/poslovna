package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.KursnaLista;
import com.example.demo.repository.KursnaListaRepository;

@Transactional
@Service
public class KursnaListaServiceImpl implements KursnaListaService {

	@Autowired
	private KursnaListaRepository kursnaListaRepository;
	
	@Override
	public KursnaLista save(KursnaLista kursnaLista) {
		return kursnaListaRepository.save(kursnaLista);
	}

	@Override
	public KursnaLista findOne(Long id) {
		return kursnaListaRepository.findById(id).get();
	}

	@Override
	public List<KursnaLista> findAll() {
		return kursnaListaRepository.findAll();
	}

	@Override
	public KursnaLista delete(Long id) {
		KursnaLista kursnaLista = kursnaListaRepository.findById(id).get();
		if(kursnaLista == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant kursnaLista");
		}
		kursnaListaRepository.delete(kursnaLista);
		return kursnaLista;
	}
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.KursUValuti;
import com.example.demo.repository.KursUValutiRepository;

@Transactional
@Service
public class KursUValutiServiceImpl implements KursUValutiService {

	@Autowired
	private KursUValutiRepository kursUValutiRepository;
	
	@Override
	public KursUValuti save(KursUValuti kurs) {
		return kursUValutiRepository.save(kurs);
	}

	@Override
	public List<KursUValuti> findAll() {
		return kursUValutiRepository.findAll();
	}

	@Override
	public KursUValuti findOne(Long id) {
		return kursUValutiRepository.findById(id).get();
	}

	@Override
	public KursUValuti delete(Long id) {
		KursUValuti kurs = kursUValutiRepository.findById(id).get();
		if(kurs == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant kurs");
		}
		kursUValutiRepository.delete(kurs);
		return kurs;
	}


}

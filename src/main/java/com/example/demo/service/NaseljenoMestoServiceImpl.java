package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.NaseljenoMesto;
import com.example.demo.repository.NaseljenoMestoRepository;

@Transactional
@Service
public class NaseljenoMestoServiceImpl implements NaseljenoMestoService {

	@Autowired
	private NaseljenoMestoRepository naseljenoMestoRepository;
	
	@Override
	public NaseljenoMesto save(NaseljenoMesto naseljenoMesto) {
		return naseljenoMestoRepository.save(naseljenoMesto);
	}

}

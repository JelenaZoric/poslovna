package com.example.demo.service;

import java.util.List;

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
	@Override
	public List<NaseljenoMesto> findAll() {
		return naseljenoMestoRepository.findAll();
	}
	@Override
	public NaseljenoMesto findOne(Long id) {
		return naseljenoMestoRepository.findById(id).get();
	}
	@Override
	public NaseljenoMesto delete(Long id) {
		NaseljenoMesto naseljenoMesto = naseljenoMestoRepository.findById(id).get();
		if(naseljenoMesto == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant naseljeno mesto");
		}
		naseljenoMestoRepository.delete(naseljenoMesto);
		return naseljenoMesto;
	}
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Banka;
import com.example.demo.model.Valute;
import com.example.demo.repository.BankaRepository;

@Transactional
@Service
public class BankaServiceImpl implements BankaService {

	@Autowired
	private BankaRepository bankaRepository;
	
	@Override
	public Banka save(Banka banka) {
		return bankaRepository.save(banka);
	}

	@Override
	public List<Banka> findAll() {
		return bankaRepository.findAll();
	}

	@Override
	public Banka findOne(Long id) {
		return bankaRepository.findById(id).get();
	}

	@Override
	public Banka delete(Long id) {
		Banka banka = bankaRepository.findById(id).get();
		if(banka == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant banka");
		}
		bankaRepository.delete(banka);
		return banka;
	}

}

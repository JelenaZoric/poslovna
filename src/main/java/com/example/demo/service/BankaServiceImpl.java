package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Banka;
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

}

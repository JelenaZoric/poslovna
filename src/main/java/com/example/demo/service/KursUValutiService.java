package com.example.demo.service;

import java.util.List;

import com.example.demo.model.KursUValuti;

public interface KursUValutiService {

	KursUValuti save(KursUValuti kurs);
	
	List<KursUValuti> findAll();
	
	KursUValuti findOne(Long id);
	
	KursUValuti delete(Long id);
}

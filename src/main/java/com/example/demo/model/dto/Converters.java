package com.example.demo.model.dto;

import com.example.demo.model.Drzava;

public class Converters {

	public static DrzavaDTO convertDrzavaToDrzavaDTO(Drzava drzava) {
		DrzavaDTO dto = new DrzavaDTO();
		dto.setId(drzava.getId());
		dto.setNazivDrzave(drzava.getNazivDrzave());
		dto.setSifraDrzave(drzava.getSifraDrzave());
		return dto;
	}
}

package com.example.demo.model.dto;

import java.io.Serializable;

public class NaseljenoMestoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int sifraMesta;
	private String naziv;
	private String pTToznaka;
	private Long drzava;
	
	public NaseljenoMestoDTO(){
		
	}



	public NaseljenoMestoDTO(int sifraMesta, String naziv, String pTToznaka,
			Long drzava) {
		super();
		this.sifraMesta = sifraMesta;
		this.naziv = naziv;
		this.pTToznaka = pTToznaka;
		this.drzava = drzava;
	}



	public Long getDrzava() {
		return drzava;
	}

	public void setDrzava(Long drzava) {
		this.drzava = drzava;
	}


	public int getSifraMesta() {
		return sifraMesta;
	}

	public void setSifraMesta(int sifraMesta) {
		this.sifraMesta = sifraMesta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public String getpTToznaka() {
		return pTToznaka;
	}



	public void setpTToznaka(String pTToznaka) {
		this.pTToznaka = pTToznaka;
	}


	
}

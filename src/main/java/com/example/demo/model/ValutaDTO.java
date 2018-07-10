package com.example.demo.model;

public class ValutaDTO {

	private String zvanicnaSifra;
	private String naziv;
	private boolean domicilna;
	private Long drzava;
	
	public ValutaDTO(String zvanicnaSifra, String naziv, boolean domicilna, Long drzava) {
		super();
		this.zvanicnaSifra = zvanicnaSifra;
		this.naziv = naziv;
		this.domicilna = domicilna;
		this.drzava = drzava;
	}

	public ValutaDTO() {
		super();
	}

	public String getZvanicnaSifra() {
		return zvanicnaSifra;
	}

	public void setZvanicnaSifra(String zvanicnaSifra) {
		this.zvanicnaSifra = zvanicnaSifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public boolean isDomicilna() {
		return domicilna;
	}

	public void setDomicilna(boolean domicilna) {
		this.domicilna = domicilna;
	}

	public Long getDrzava() {
		return drzava;
	}

	public void setDrzava(Long drzava) {
		this.drzava = drzava;
	}
	
	
}

package com.example.demo.model.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.model.RacunDTO;
import com.example.demo.model.RacuniPravnihLica;
import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name="klijent")
@XmlAccessorType(XmlAccessType.FIELD)
public class KlijentDTO {

	private Long id;
	private String nazivKlijenta;
	private String mesto;
	private String adresa;
	private String telefon;
	private String faks;
	private String email;
	private String jmbg;
	private String odgovornoLice;
	private String nazivDelatnosti;
	private Integer sifraDelatnosti;
	private String nadlezniPoreskiOrgan;
	private Integer poreskiBroj;
	private boolean aktivan;
	@XmlElements(value = {@XmlElement(name = "racuni", type = RacuniPravnihLica.class)})
    @XmlElementWrapper
	private Set<RacuniPravnihLica> listaRacunaPravnihLica = new HashSet<RacuniPravnihLica>();
	
	public KlijentDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivKlijenta() {
		return nazivKlijenta;
	}

	public void setNazivKlijenta(String nazivKlijenta) {
		this.nazivKlijenta = nazivKlijenta;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFaks() {
		return faks;
	}

	public void setFaks(String faks) {
		this.faks = faks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getOdgovornoLice() {
		return odgovornoLice;
	}

	public void setOdgovornoLice(String odgovornoLice) {
		this.odgovornoLice = odgovornoLice;
	}

	public String getNazivDelatnosti() {
		return nazivDelatnosti;
	}

	public void setNazivDelatnosti(String nazivDelatnosti) {
		this.nazivDelatnosti = nazivDelatnosti;
	}

	public Integer getSifraDelatnosti() {
		return sifraDelatnosti;
	}

	public void setSifraDelatnosti(Integer sifraDelatnosti) {
		this.sifraDelatnosti = sifraDelatnosti;
	}

	public String getNadlezniPoreskiOrgan() {
		return nadlezniPoreskiOrgan;
	}

	public void setNadlezniPoreskiOrgan(String nadlezniPoreskiOrgan) {
		this.nadlezniPoreskiOrgan = nadlezniPoreskiOrgan;
	}

	public Integer getPoreskiBroj() {
		return poreskiBroj;
	}

	public void setPoreskiBroj(Integer poreskiBroj) {
		this.poreskiBroj = poreskiBroj;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public Set<RacuniPravnihLica> getListaRacunaPravnihLica() {
		return listaRacunaPravnihLica;
	}

	public void setListaRacunaPravnihLica(
			Set<RacuniPravnihLica> listaRacunaPravnihLica) {
		this.listaRacunaPravnihLica = listaRacunaPravnihLica;
	}
}

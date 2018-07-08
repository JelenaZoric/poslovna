package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Klijent implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private int idKlijenta;
	
	@Column(nullable=true)
	private String nazivKlijenta;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "klijent")
	private Set<RacuniPravnihLica> listaRacunaPravnihLica = new HashSet<RacuniPravnihLica>();

	public Klijent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Klijent(Long id, int idKlijenta, String nazivKlijenta
			, Set<RacuniPravnihLica> listaRacunaPravnihLica) {
		super();
		this.id = id;
		this.idKlijenta = idKlijenta;
		this.nazivKlijenta = nazivKlijenta;
		this.listaRacunaPravnihLica = listaRacunaPravnihLica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdKlijenta() {
		return idKlijenta;
	}

	public void setIdKlijenta(int idKlijenta) {
		this.idKlijenta = idKlijenta;
	}

	public String getNazivKlijenta() {
		return nazivKlijenta;
	}

	public void setNazivKlijenta(String nazivKlijenta) {
		this.nazivKlijenta = nazivKlijenta;
	}

	public Set<RacuniPravnihLica> getListaRacunaPravnihLica() {
		return listaRacunaPravnihLica;
	}

	public void setListaRacunaPravnihLica(
			Set<RacuniPravnihLica> listaRacunaPravnihLica) {
		this.listaRacunaPravnihLica = listaRacunaPravnihLica;
	}
	
}

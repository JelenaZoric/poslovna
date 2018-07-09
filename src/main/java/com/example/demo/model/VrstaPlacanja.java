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
public class VrstaPlacanja implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private int oznakaVrste;
	
	@Column(nullable=false)
	private String nazivVrstePlacanja;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vrstaPlacanja")
	private Set<AnalitikaIzvoda> listaAnalitikaIzvoda = new HashSet<AnalitikaIzvoda>();

	public VrstaPlacanja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VrstaPlacanja(int oznakaVrste, String nazivVrstePlacanja,
			Set<AnalitikaIzvoda> listaAnalitikaIzvoda) {
		super();
		this.oznakaVrste = oznakaVrste;
		this.nazivVrstePlacanja = nazivVrstePlacanja;
		this.listaAnalitikaIzvoda = listaAnalitikaIzvoda;
	}
	
	public VrstaPlacanja(int oznakaVrste, String nazivVrstePlacanja) {
		super();
		this.oznakaVrste = oznakaVrste;
		this.nazivVrstePlacanja = nazivVrstePlacanja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOznakaVrste() {
		return oznakaVrste;
	}

	public void setOznakaVrste(int oznakaVrste) {
		this.oznakaVrste = oznakaVrste;
	}

	public String getNazivVrstePlacanja() {
		return nazivVrstePlacanja;
	}

	public void setNazivVrstePlacanja(String nazivVrstePlacanja) {
		this.nazivVrstePlacanja = nazivVrstePlacanja;
	}

	public Set<AnalitikaIzvoda> getListaAnalitikaIzvoda() {
		return listaAnalitikaIzvoda;
	}

	public void setListaAnalitikaIzvoda(Set<AnalitikaIzvoda> listaAnalitikaIzvoda) {
		this.listaAnalitikaIzvoda = listaAnalitikaIzvoda;
	}
}

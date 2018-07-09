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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NaseljenoMesto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="sifra", nullable=false)
	private int sifraMesta;
	
	@Column(name="naziv", nullable=false)
	private String naziv;
	
	@Column(name="PTToznaka", nullable=false)
	private String PTToznaka;
	
	@ManyToOne(optional = false)
	private Drzava drzava; 
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "naseljenoMesto")
	private Set<AnalitikaIzvoda> listaAnalitikaIzvoda = new HashSet<AnalitikaIzvoda>();

	public NaseljenoMesto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NaseljenoMesto(int sifraMesta, String naziv,
			String pTToznaka, Drzava drzava,
			Set<AnalitikaIzvoda> listaAnalitikaIzvoda) {
		super();
		this.sifraMesta = sifraMesta;
		this.naziv = naziv;
		PTToznaka = pTToznaka;
		this.drzava = drzava;
		this.listaAnalitikaIzvoda = listaAnalitikaIzvoda;
	}
	
	public NaseljenoMesto(int sifraMesta, String naziv,
			String pTToznaka, Drzava drzava) {
		super();
		this.sifraMesta = sifraMesta;
		this.naziv = naziv;
		PTToznaka = pTToznaka;
		this.drzava = drzava;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPTToznaka() {
		return PTToznaka;
	}

	public void setPTToznaka(String pTToznaka) {
		PTToznaka = pTToznaka;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	public Set<AnalitikaIzvoda> getListaAnalitikaIzvoda() {
		return listaAnalitikaIzvoda;
	}

	public void setListaAnalitikaIzvoda(Set<AnalitikaIzvoda> listaAnalitikaIzvoda) {
		this.listaAnalitikaIzvoda = listaAnalitikaIzvoda;
	}
}

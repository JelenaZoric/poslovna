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
public class Valute implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="sifra", nullable=false)
	private String zvanicnaSifra;
	
	@Column(name="naziv", nullable=false)
	private String naziv;
	
	@Column(name="domicilna", nullable=false)
	private boolean domicilna;

	@ManyToOne(optional = false)
	private Drzava drzava; 

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="valutaOsnovna")
	private Set<KursUValuti> osnovnaValuta = new HashSet<KursUValuti>();
	//?????
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="valutaPrema")
	private Set<KursUValuti> premaValuti = new HashSet<KursUValuti>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="valute")
	private Set<RacuniPravnihLica> listaRacunaPravnihLica = new HashSet<RacuniPravnihLica>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="valute")
	private Set<AnalitikaIzvoda> listaAnalitikaIzvoda = new HashSet<AnalitikaIzvoda>();

	public Valute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Valute(String zvanicnaSifra, String naziv,
			boolean domicilna, Drzava drzava) {
		super();
		this.zvanicnaSifra = zvanicnaSifra;
		this.naziv = naziv;
		this.domicilna = domicilna;
		this.drzava = drzava;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	public Set<KursUValuti> getOsnovnaValuta() {
		return osnovnaValuta;
	}

	public void setOsnovnaValuta(Set<KursUValuti> osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}

	public Set<KursUValuti> getPremaValuti() {
		return premaValuti;
	}

	public void setPremaValuti(Set<KursUValuti> premaValuti) {
		this.premaValuti = premaValuti;
	}

	public Set<RacuniPravnihLica> getListaRacunaPravnihLica() {
		return listaRacunaPravnihLica;
	}

	public void setListaRacunaPravnihLica(
			Set<RacuniPravnihLica> listaRacunaPravnihLica) {
		this.listaRacunaPravnihLica = listaRacunaPravnihLica;
	}

	public Set<AnalitikaIzvoda> getListaAnalitikaIzvoda() {
		return listaAnalitikaIzvoda;
	}

	public void setListaAnalitikaIzvoda(Set<AnalitikaIzvoda> listaAnalitikaIzvoda) {
		this.listaAnalitikaIzvoda = listaAnalitikaIzvoda;
	}
}


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
	
	@Column(nullable=true)
	private String mesto;
	
	@Column(nullable=true)
	private String adresa;
	
	@Column(nullable=true)
	private String telefon;
	
	@Column(nullable=true)
	private String faks;
	
	@Column(nullable=true)
	private String email;
	
	@Column(nullable=true)
	private String jmbg;
	
	@Column(nullable=true)
	private String odgovornoLice;
	
	@Column(nullable=true)
	private String nazivDelatnosti;
	
	@Column(nullable=true)
	private Integer sifraDelatnosti;
	
	@Column(nullable=true)
	private String nadlezniPoreskiOrgan;
	
	@Column(nullable=true)
	private Integer poreskiBroj;
	
	@Column(nullable=true)
	private boolean aktivan;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "klijent")
	private Set<RacuniPravnihLica> listaRacunaPravnihLica = new HashSet<RacuniPravnihLica>();

	public Klijent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Klijent(int idKlijenta, String nazivKlijenta) {
		super();
		this.idKlijenta = idKlijenta;
		this.nazivKlijenta = nazivKlijenta;
	}
	
	public Klijent(int idKlijenta, String nazivKlijenta, String mesto, String adresa, String telefon, String faks, String email,
			String jmbg, String odgovornoLice, String nazivDelatnosti, Integer sifraDelatnosti, String nadlezniPoreskiOrgan,
			Integer poreskiBroj, boolean aktivan/*, Set<RacuniPravnihLica> listaRacunaPravnihLica*/) {
		super();
		this.idKlijenta = idKlijenta;
		this.nazivKlijenta = nazivKlijenta;
		this.mesto = mesto;
		this.adresa = adresa;
		this.telefon = telefon;
		this.faks = faks;
		this.email = email;
		this.jmbg = jmbg;
		this.odgovornoLice = odgovornoLice;
		this.nazivDelatnosti = nazivDelatnosti;
		this.sifraDelatnosti = sifraDelatnosti;
		this.nadlezniPoreskiOrgan = nadlezniPoreskiOrgan;
		this.poreskiBroj = poreskiBroj;
		this.aktivan = aktivan;
		//this.listaRacunaPravnihLica = listaRacunaPravnihLica;
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

	@Override
	public String toString() {
		return "Klijent [id=" + id + ", idKlijenta=" + idKlijenta + ", nazivKlijenta=" + nazivKlijenta + ", mesto="
				+ mesto + ", adresa=" + adresa + ", telefon=" + telefon + ", faks=" + faks + ", email=" + email
				+ ", jmbg=" + jmbg + ", odgovornoLice=" + odgovornoLice + ", nazivDelatnosti=" + nazivDelatnosti
				+ ", sifraDelatnosti=" + sifraDelatnosti + ", nadlezniPoreskiOrgan=" + nadlezniPoreskiOrgan
				+ ", poreskiBroj=" + poreskiBroj + ", listaRacunaPravnihLica=" + listaRacunaPravnihLica + "]";
	}

	
}

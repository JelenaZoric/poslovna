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
public class Banka implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private int idBanke;
	
	@Column(nullable=false)
	private String sifraBanke;
	
	@Column(nullable=false)
	private String pib;
	
	@Column(nullable=false)
	private String naziv;
	
	@Column(nullable=false)
	private String adresa;
	
	@Column(nullable=true)
	private String email;
	
	@Column(nullable=true)
	private String web;
	
	@Column(nullable=true)
	private String telefon;
	
	@Column(nullable=true)
	private String fax;
	
	@Column(name="banka", nullable=false)
	private boolean banka;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "banka")
	private Set<RacuniPravnihLica> listaRacunaPravnihLica = new HashSet<RacuniPravnihLica>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "banka")
	private Set<KursnaLista> listaKursnihLista = new HashSet<KursnaLista>();
	
	public Banka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banka(Long id, int idBanke, String sifraBanke, String pib,
			String naziv, String adresa, String email, String web,
			String telefon, String fax, boolean banka,
			Set<RacuniPravnihLica> listaRacunaPravnihLica,
			Set<KursnaLista> listaKursnihLista) {
		super();
		this.id = id;
		this.idBanke = idBanke;
		this.sifraBanke = sifraBanke;
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.email = email;
		this.web = web;
		this.telefon = telefon;
		this.fax = fax;
		this.banka = banka;
		this.listaRacunaPravnihLica = listaRacunaPravnihLica;
		this.listaKursnihLista = listaKursnihLista;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getIdBanke() {
		return idBanke;
	}


	public void setIdBanke(int idBanke) {
		this.idBanke = idBanke;
	}


	public String getSifraBanke() {
		return sifraBanke;
	}


	public void setSifraBanke(String sifraBanke) {
		this.sifraBanke = sifraBanke;
	}


	public String getPib() {
		return pib;
	}


	public void setPib(String pib) {
		this.pib = pib;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public boolean isBanka() {
		return banka;
	}


	public void setBanka(boolean banka) {
		this.banka = banka;
	}


	public Set<RacuniPravnihLica> getListaRacunaPravnihLica() {
		return listaRacunaPravnihLica;
	}


	public void setListaRacunaPravnihLica(
			Set<RacuniPravnihLica> listaRacunaPravnihLica) {
		this.listaRacunaPravnihLica = listaRacunaPravnihLica;
	}

	public Set<KursnaLista> getListaKursnihLista() {
		return listaKursnihLista;
	}

	public void setListaKursnihLista(Set<KursnaLista> listaKursnihLista) {
		this.listaKursnihLista = listaKursnihLista;
	}
}

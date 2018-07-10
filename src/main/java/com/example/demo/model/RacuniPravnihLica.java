package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;
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
public class RacuniPravnihLica implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Long idRacuna;
	
	@Column(nullable=false)
	private String brojRacuna;
	
	@Column(nullable=false)
	private String datumOtvaranja;
	
	@Column(name="vazeci", nullable=false)
	private boolean vazeci;
	
	@ManyToOne(/*optional = false*/)
	private Banka banka;

	@ManyToOne(/*optional = false*/)
	private Valute valute;
	
	@ManyToOne(/*optional = false*/)
	private Klijent klijent;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "racuniPravnihLica")
	private Set<DnevnoStanjeRacuna> listaDnevnihStanjaRacuna = new HashSet<DnevnoStanjeRacuna>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "racuniPravnihLica")
	private Set<Ukidanje> listaUkidanja = new HashSet<Ukidanje>();
	
	public RacuniPravnihLica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public RacuniPravnihLica(Long idRacuna, String brojRacuna, String datumOtvaranja, boolean vazeci, Valute valute,
			Klijent klijent) {
		super();
		this.idRacuna = idRacuna;
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
		this.valute = valute;
		this.klijent = klijent;
	}



	public RacuniPravnihLica(Long idRacuna, String brojRacuna,
			String datumOtvaranja, boolean vazeci, Valute valute,
			Set<DnevnoStanjeRacuna> listaDnevnihStanjaRacuna,
			Set<Ukidanje> listaUkidanja, Klijent klijent, Banka banka) {
		super();
		this.idRacuna = idRacuna;
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
		this.valute = valute;
		this.listaDnevnihStanjaRacuna = listaDnevnihStanjaRacuna;
		this.listaUkidanja = listaUkidanja;
		this.klijent = klijent;
		this.banka = banka;
	}
	
	public RacuniPravnihLica(Long idRacuna, String brojRacuna,
			String datumOtvaranja, boolean vazeci, Valute valute, Klijent klijent, Banka banka) {
		super();
		this.idRacuna = idRacuna;
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
		this.valute = valute;
		this.klijent = klijent;
		this.banka = banka;
	}
	public RacuniPravnihLica(String brojRacuna,
			String datumOtvaranja) {
		super();
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		//this.valute = valute;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRacuna() {
		return idRacuna;
	}

	public void setIdRacuna(Long idRacuna) {
		this.idRacuna = idRacuna;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(String datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public boolean isVazeci() {
		return vazeci;
	}

	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}

	public Valute getValute() {
		return valute;
	}

	public void setValute(Valute valute) {
		this.valute = valute;
	}

	public Set<DnevnoStanjeRacuna> getListaDnevnihStanjaRacuna() {
		return listaDnevnihStanjaRacuna;
	}

	public void setListaDnevnihStanjaRacuna(
			Set<DnevnoStanjeRacuna> listaDnevnihStanjaRacuna) {
		this.listaDnevnihStanjaRacuna = listaDnevnihStanjaRacuna;
	}

	public Set<Ukidanje> getListaUkidanja() {
		return listaUkidanja;
	}

	public void setListaUkidanja(Set<Ukidanje> listaUkidanja) {
		this.listaUkidanja = listaUkidanja;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}
	
}

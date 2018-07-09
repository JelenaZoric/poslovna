package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ukidanje implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private int idUkidanja;
	
	@Column(nullable=false)
	private Date datumUkidanja;
	
	@Column(nullable=false)
	private String sredstvaSePrenoseNaRacun;
	
	@ManyToOne(optional = false)
	private RacuniPravnihLica racuniPravnihLica;

	public Ukidanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ukidanje(Long id, int idUkidanja, Date datumUkidanja,
			String sredstvaSePrenoseNaRacun, RacuniPravnihLica racuniPravnihLica) {
		super();
		this.id = id;
		this.idUkidanja = idUkidanja;
		this.datumUkidanja = datumUkidanja;
		this.sredstvaSePrenoseNaRacun = sredstvaSePrenoseNaRacun;
		this.racuniPravnihLica = racuniPravnihLica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdUkidanja() {
		return idUkidanja;
	}

	public void setIdUkidanja(int idUkidanja) {
		this.idUkidanja = idUkidanja;
	}

	public Date getDatumUkidanja() {
		return datumUkidanja;
	}

	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}

	public String getSredstvaSePrenoseNaRacun() {
		return sredstvaSePrenoseNaRacun;
	}

	public void setSredstvaSePrenoseNaRacun(String sredstvaSePrenoseNaRacun) {
		this.sredstvaSePrenoseNaRacun = sredstvaSePrenoseNaRacun;
	}

	public RacuniPravnihLica getRacuniPravnihLica() {
		return racuniPravnihLica;
	}

	public void setRacuniPravnihLica(RacuniPravnihLica racuniPravnihLica) {
		this.racuniPravnihLica = racuniPravnihLica;
	}
}

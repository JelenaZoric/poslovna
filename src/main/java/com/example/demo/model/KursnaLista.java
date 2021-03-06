package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
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
public class KursnaLista implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private int idKursneListe;
	
	@Column(nullable=false)
	private String datum;
	
	@Column(nullable=false)
	private int brojKursneListe;
	
	@Column(nullable=false)
	private String primenjujeSeOd;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "kursnaLista")
	private Set<KursUValuti> listaKursevaUvaluti = new HashSet<KursUValuti>();
	
	@ManyToOne(optional = false)
	private Banka banka;

	public KursnaLista() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public KursnaLista(int idKursneListe, String datum, int brojKursneListe, String primenjujeSeOd, Banka banka) {
		super();
		this.idKursneListe = idKursneListe;
		this.datum = datum;
		this.brojKursneListe = brojKursneListe;
		this.primenjujeSeOd = primenjujeSeOd;
		this.banka = banka;
	}



	public KursnaLista(Long id, int idKursneListe, String datum,
			int brojKursneListe, String primenjujeSeOd,
			Set<KursUValuti> listaKursevaUvaluti, Banka banka) {
		super();
		this.id = id;
		this.idKursneListe = idKursneListe;
		this.datum = datum;
		this.brojKursneListe = brojKursneListe;
		this.primenjujeSeOd = primenjujeSeOd;
		this.listaKursevaUvaluti = listaKursevaUvaluti;
		this.banka = banka;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdKursneListe() {
		return idKursneListe;
	}

	public void setIdKursneListe(int idKursneListe) {
		this.idKursneListe = idKursneListe;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public int getBrojKursneListe() {
		return brojKursneListe;
	}

	public void setBrojKursneListe(int brojKursneListe) {
		this.brojKursneListe = brojKursneListe;
	}

	public String getPrimenjujeSeOd() {
		return primenjujeSeOd;
	}

	public void setPrimenjujeSeOd(String primenjujeSeOd) {
		this.primenjujeSeOd = primenjujeSeOd;
	}

	public Set<KursUValuti> getListaKursevaUvaluti() {
		return listaKursevaUvaluti;
	}

	public void setListaKursevaUvaluti(Set<KursUValuti> listaKursevaUvaluti) {
		this.listaKursevaUvaluti = listaKursevaUvaluti;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}
}

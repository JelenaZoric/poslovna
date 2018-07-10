package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
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
public class Drzava implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="Sifra", nullable = false)
	private int sifraDrzave;
	
	@Column(name="Naziv", nullable=false)
	private String nazivDrzave;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "drzava")
	private Set<Valute> drzavnaValuta = new HashSet<Valute>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "drzava")
	private Set<NaseljenoMesto> mestaUDrzavi = new HashSet<NaseljenoMesto>();
    
	public Drzava() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drzava(int sifraDrzave, String nazivDrzave,
			Set<Valute> drzavnaValuta, Set<NaseljenoMesto> mestaUDrzavi) {
		super();
		this.sifraDrzave = sifraDrzave;
		this.nazivDrzave = nazivDrzave;
		this.drzavnaValuta = drzavnaValuta;
		this.mestaUDrzavi = mestaUDrzavi;  
	}
	
	public Drzava(int sifraDrzave, String nazivDrzave) {
		super();
		this.sifraDrzave = sifraDrzave;
		this.nazivDrzave = nazivDrzave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSifraDrzave() {
		return sifraDrzave;
	}

	public void setSifraDrzave(int sifraDrzave) {
		this.sifraDrzave = sifraDrzave;
	}

	public String getNazivDrzave() {
		return nazivDrzave;
	}

	public void setNazivDrzave(String nazivDrzave) {
		this.nazivDrzave = nazivDrzave;
	}

	public Set<Valute> getDrzavnaValuta() {
		return drzavnaValuta;
	}

	public void setDrzavnaValuta(Set<Valute> drzavnaValuta) {
		this.drzavnaValuta = drzavnaValuta;
	}

	public Set<NaseljenoMesto> getMestaUDrzavi() {
		return mestaUDrzavi;
	}

	public void setMestaUDrzavi(Set<NaseljenoMesto> mestaUDrzavi) {
		this.mestaUDrzavi = mestaUDrzavi;
	}  
}

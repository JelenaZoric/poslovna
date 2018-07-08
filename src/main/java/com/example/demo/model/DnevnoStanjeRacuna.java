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
public class DnevnoStanjeRacuna implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Long brojIzvoda;
	
	@Column(nullable=false)
	private String datumPrometa;
	
	@Column(nullable=false)
	private float prethodnoStanje;
	
	@Column(nullable=false)
	private float prometUKorist;
	
	@Column(nullable=false)
	private float prometNaTeret;
	
	@Column(nullable=false)
	private float novoStanje;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dnevnoStanjeRacuna")
	private Set<AnalitikaIzvoda> listaAnalitikeIzvoda = new HashSet<AnalitikaIzvoda>();

	@ManyToOne(optional = false)
	private RacuniPravnihLica racuniPravnihLica;

	public DnevnoStanjeRacuna() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnevnoStanjeRacuna(Long id, Long brojIzvoda, String datumPrometa,
			float predhodnoStanje, float prometUKorist, float prometNaTeret,
			float novoStanje, Set<AnalitikaIzvoda> listaAnalitikeIzvoda,
			RacuniPravnihLica racuniPravnihLica) {
		super();
		this.id = id;
		this.brojIzvoda = brojIzvoda;
		this.datumPrometa = datumPrometa;
		this.prethodnoStanje = predhodnoStanje;
		this.prometUKorist = prometUKorist;
		this.prometNaTeret = prometNaTeret;
		this.novoStanje = novoStanje;
		this.listaAnalitikeIzvoda = listaAnalitikeIzvoda;
		this.racuniPravnihLica = racuniPravnihLica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrojIzvoda() {
		return brojIzvoda;
	}

	public void setBrojIzvoda(Long brojIzvoda) {
		this.brojIzvoda = brojIzvoda;
	}

	public String getDatumPrometa() {
		return datumPrometa;
	}

	public void setDatumPrometa(String datumPrometa) {
		this.datumPrometa = datumPrometa;
	}

	public float getPredhodnoStanje() {
		return prethodnoStanje;
	}

	public void setPredhodnoStanje(float predhodnoStanje) {
		this.prethodnoStanje = predhodnoStanje;
	}

	public float getPrometUKorist() {
		return prometUKorist;
	}

	public void setPrometUKorist(float prometUKorist) {
		this.prometUKorist = prometUKorist;
	}

	public float getPrometNaTeret() {
		return prometNaTeret;
	}

	public void setPrometNaTeret(float prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}

	public float getNovoStanje() {
		return novoStanje;
	}

	public void setNovoStanje(float novoStanje) {
		this.novoStanje = novoStanje;
	}

	public Set<AnalitikaIzvoda> getListaAnalitikeIzvoda() {
		return listaAnalitikeIzvoda;
	}

	public void setListaAnalitikeIzvoda(Set<AnalitikaIzvoda> listaAnalitikeIzvoda) {
		this.listaAnalitikeIzvoda = listaAnalitikeIzvoda;
	}

	public RacuniPravnihLica getRacuniPravnihLica() {
		return racuniPravnihLica;
	}

	public void setRacuniPravnihLica(RacuniPravnihLica racuniPravnihLica) {
		this.racuniPravnihLica = racuniPravnihLica;
	}
}

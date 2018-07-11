package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KursUValuti implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="redni_broj", nullable=false)
	private int redniBroj;
	
	@Column(nullable=false)
	private float kupovni;
	
	@Column(nullable=false)
	private float srednji;
	
	@Column(nullable=false)
	private float prodajni;
	
	@ManyToOne(optional = false)
	private Valute valutaOsnovna;
	
	@ManyToOne(optional = false)
	private Valute valutaPrema;
	
	@ManyToOne(optional = false)
	private KursnaLista kursnaLista;

	public KursUValuti() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KursUValuti(Long id, int redniBroj, float kupovni, float srednji,
			float prodajni, Valute valutaOsnovna, Valute valutaPrema,
			KursnaLista kursnaLista) {
		super();
		this.id = id;
		this.redniBroj = redniBroj;
		this.kupovni = kupovni;
		this.srednji = srednji;
		this.prodajni = prodajni;
		this.valutaOsnovna = valutaOsnovna;
		this.valutaPrema = valutaPrema;
		this.kursnaLista = kursnaLista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public float getKupovni() {
		return kupovni;
	}

	public void setKupovni(float kupovni) {
		this.kupovni = kupovni;
	}

	public float getSrednji() {
		return srednji;
	}

	public void setSrednji(float srednji) {
		this.srednji = srednji;
	}

	public float getProdajni() {
		return prodajni;
	}

	public void setProdajni(float prodajni) {
		this.prodajni = prodajni;
	}

	public Valute getValutaOsnovna() {
		return valutaOsnovna;
	}

	public void setValutaOsnovna(Valute valutaOsnovna) {
		this.valutaOsnovna = valutaOsnovna;
	}

	public Valute getValutaPrema() {
		return valutaPrema;
	}

	public void setValutaPrema(Valute valutaPrema) {
		this.valutaPrema = valutaPrema;
	}

	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}
}

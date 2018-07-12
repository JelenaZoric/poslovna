package com.example.demo.model;

public class KursUValutiDTO {

	private int redniBroj;
	private float kupovni;
	private float srednji;
	private float prodajni;
	private Long valutaOsnovna;
	private Long valutaPrema;
	private Long kursnaLista;
	
	public KursUValutiDTO(int redniBroj, float kupovni, float srednji, float prodajni, Long valutaOsnovna,
			Long valutaPrema, Long kursnaLista) {
		super();
		this.redniBroj = redniBroj;
		this.kupovni = kupovni;
		this.srednji = srednji;
		this.prodajni = prodajni;
		this.valutaOsnovna = valutaOsnovna;
		this.valutaPrema = valutaPrema;
		this.kursnaLista = kursnaLista;
	}

	public KursUValutiDTO() {
		super();
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

	public Long getValutaOsnovna() {
		return valutaOsnovna;
	}

	public void setValutaOsnovna(Long valutaOsnovna) {
		this.valutaOsnovna = valutaOsnovna;
	}

	public Long getValutaPrema() {
		return valutaPrema;
	}

	public void setValutaPrema(Long valutaPrema) {
		this.valutaPrema = valutaPrema;
	}

	public Long getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(Long kursnaLista) {
		this.kursnaLista = kursnaLista;
	}
	
	
}

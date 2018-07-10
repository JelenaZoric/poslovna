package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class AnalitikaIzvoda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String duznikNalogodavac;
	
	@Column(nullable=false)
	private String svrhaPlacanja;
	
	@Column(nullable=false)
	private String poverilacPrimalac;
	
	@Column(nullable=false)
	private String datumPrijema;
	
	@Column(nullable=false)
	private String datumValute;
	
	@Column(nullable=true)
	private String racunDuznika;
	
	@Column(nullable=true)
	private int modelZaduzenja;
	
	@Column(nullable=true)
	private String pozivNaBrojZaduzenja;
	
	@Column(nullable=true)
	private String racunPoverioca;
	
	@Column(nullable=true)
	private int modelOdobrenja;
	
	@Column(nullable=true)
	private String pozivNaBrojOdobrenja;
	
	@Column(name="hitno", nullable=false)
	private boolean hitno;
	
	@Column(nullable=false)
	private float iznos;
	
	@Column(nullable=false)
	private int tipGreske;
	
	@Column(nullable=false)
	private char status;
	
	@ManyToOne(optional = true)
	private Valute valute;

	@ManyToOne(optional = true)
	private NaseljenoMesto naseljenoMesto;
	
	@ManyToOne(optional = true)
	private VrstaPlacanja vrstaPlacanja;

	@ManyToOne(/*optional = false*/)
	private DnevnoStanjeRacuna dnevnoStanjeRacuna; 

	public AnalitikaIzvoda() {
		super();
		this.status = '1';		//uspesna transakcija
		this.tipGreske = 1;		//izvrsen nalog
	}

	public AnalitikaIzvoda(Long id, String duznikNalogodavac,
			String svrhaPlacanja, String poverilacPrimalac, String datumPrijema,
			String datumValute, String racunDuznika, int modelZaduzenja,
			String pozivNaBrojZaduzenja, String racunPoverioca,
			int modelOdobrenja, String pozivNaBrojOdobrenja, boolean hitno,
			float iznos, int tipGreske, char status, Valute valute,
			NaseljenoMesto naseljenoMesto, VrstaPlacanja vrstaPlacanja,
			DnevnoStanjeRacuna dnevnoStanjeRacuna) {
		super();
		this.id = id;
		this.duznikNalogodavac = duznikNalogodavac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.poverilacPrimalac = poverilacPrimalac;
		this.datumPrijema = datumPrijema;
		this.datumValute = datumValute;
		this.racunDuznika = racunDuznika;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
		this.racunPoverioca = racunPoverioca;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.hitno = hitno;
		this.iznos = iznos;
		this.tipGreske = tipGreske;
		this.status = status;
	/*	this.valute = valute;
		this.naseljenoMesto = naseljenoMesto;
		this.vrstaPlacanja = vrstaPlacanja;
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;  */
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDuznikNalogodavac() {
		return duznikNalogodavac;
	}

	public void setDuznikNalogodavac(String duznikNalogodavac) {
		this.duznikNalogodavac = duznikNalogodavac;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public String getPoverilacPrimalac() {
		return poverilacPrimalac;
	}

	public void setPoverilacPrimalac(String poverilacPrimalac) {
		this.poverilacPrimalac = poverilacPrimalac;
	}

	public String getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(String datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public String getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(String datumValute) {
		this.datumValute = datumValute;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public int getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(int modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public int getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(int modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}

	public float getIznos() {
		return iznos;
	}

	public void setIznos(float iznos) {
		this.iznos = iznos;
	}

	public int getTipGreske() {
		return tipGreske;
	}

	public void setTipGreske(int tipGreske) {
		this.tipGreske = tipGreske;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Valute getValute() {
		return valute;
	}

	public void setValute(Valute valute) {
		this.valute = valute;
	}

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	public VrstaPlacanja getVrstaPlacanja() {
		return vrstaPlacanja;
	}

	public void setVrstaPlacanja(VrstaPlacanja vrstaPlacanja) {
		this.vrstaPlacanja = vrstaPlacanja;
	}

	public DnevnoStanjeRacuna getDnevnoStanjeRacuna() {
		return dnevnoStanjeRacuna;
	}

	public void setDnevnoStanjeRacuna(DnevnoStanjeRacuna dnevnoStanjeRacuna) {
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
	} 
}

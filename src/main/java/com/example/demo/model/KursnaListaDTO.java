package com.example.demo.model;

public class KursnaListaDTO {

	public int idKursneListe;
	public String datum;
	public int brojKursneListe;
	public String primenjujeSeOd;
	public Long banka;
	
	public KursnaListaDTO(int idKursneListe, String datum, int brojKursneListe, String primenjujeSeOd, Long banka) {
		super();
		this.idKursneListe = idKursneListe;
		this.datum = datum;
		this.brojKursneListe = brojKursneListe;
		this.primenjujeSeOd = primenjujeSeOd;
		this.banka = banka;
	}
	
	public KursnaListaDTO() {
		super();
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

	public Long getBanka() {
		return banka;
	}

	public void setBanka(Long banka) {
		this.banka = banka;
	}
	
	
}

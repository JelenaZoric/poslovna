package com.example.demo.model;

public class RacunDTO {

	private Long idRacuna;
	private String brojRacuna;
	private String datumOtvaranja;
	private Long valute;
	private Long klijent;
	private Long banka;
	
	public RacunDTO(Long idRacuna, String brojRacuna, String datumOtvaranja, Long valute, Long klijent, Long banka) {
		super();
		this.idRacuna = idRacuna;
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.valute = valute;
		this.klijent = klijent;
		this.banka = banka;
	}

	public RacunDTO() {
		super();
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

	public Long getValute() {
		return valute;
	}

	public void setValute(Long valute) {
		this.valute = valute;
	}

	public Long getKlijent() {
		return klijent;
	}

	public void setKlijent(Long klijent) {
		this.klijent = klijent;
	}

	public Long getBanka() {
		return banka;
	}

	public void setBanka(Long banka) {
		this.banka = banka;
	}
	
	
}

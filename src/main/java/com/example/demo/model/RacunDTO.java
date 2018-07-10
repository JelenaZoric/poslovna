package com.example.demo.model;

public class RacunDTO {

	private Long idRacuna;
	private String brojRacuna;
	private String datumOtvaranja;
	private Long valute;
	private Long klijent;
	
	public RacunDTO(Long idRacuna, String brojRacuna, String datumOtvaranja, Long valute, Long klijent) {
		super();
		this.idRacuna = idRacuna;
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.valute = valute;
		this.klijent = klijent;
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
	
	
}

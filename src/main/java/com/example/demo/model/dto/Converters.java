package com.example.demo.model.dto;

import com.example.demo.model.AnalitikaIzvoda;
import com.example.demo.model.Drzava;
import com.example.demo.model.Klijent;

public class Converters {

	public static DrzavaDTO convertDrzavaToDrzavaDTO(Drzava drzava) {
		DrzavaDTO dto = new DrzavaDTO();
		dto.setId(drzava.getId());
		dto.setNazivDrzave(drzava.getNazivDrzave());
		dto.setSifraDrzave(drzava.getSifraDrzave());
		return dto;
	}
	
	public static AnalitikaIzvodaDTO convertAnalitikaIzvodaToAnalitikaIzvodaDTO(AnalitikaIzvoda analitika) {
		AnalitikaIzvodaDTO dto = new AnalitikaIzvodaDTO();
		dto.setDuznikNalogodavac(analitika.getDuznikNalogodavac());
		dto.setHitno(analitika.isHitno());
		dto.setId(analitika.getId());
		dto.setIznos(analitika.getIznos());
		dto.setModelOdobrenja(analitika.getModelOdobrenja());
		dto.setModelZaduzenja(analitika.getModelZaduzenja());
		dto.setPoverilacPrimalac(analitika.getPoverilacPrimalac());
		dto.setPozivNaBrojOdobrenja(analitika.getPozivNaBrojOdobrenja());
		dto.setPozivNaBrojZaduzenja(analitika.getPozivNaBrojZaduzenja());
		dto.setRacunDuznika(analitika.getRacunDuznika());
		dto.setRacunPoverioca(analitika.getRacunPoverioca());
		dto.setSvrhaPlacanja(analitika.getSvrhaPlacanja());
		return dto;
	}
	
	public static KlijentDTO convertKlijentToKlijentDTO(Klijent klijent) {
		KlijentDTO dto = new KlijentDTO();
		dto.setAdresa(klijent.getAdresa());
		dto.setAktivan(klijent.isAktivan());
		dto.setEmail(klijent.getEmail());
		dto.setFaks(klijent.getFaks());
		dto.setId(klijent.getId());
		dto.setJmbg(klijent.getJmbg());
		dto.setListaRacunaPravnihLica(klijent.getListaRacunaPravnihLica());
		dto.setMesto(klijent.getMesto());
		dto.setNadlezniPoreskiOrgan(klijent.getNadlezniPoreskiOrgan());
		dto.setNazivDelatnosti(klijent.getNazivDelatnosti());
		dto.setNazivKlijenta(klijent.getNazivKlijenta());
		dto.setOdgovornoLice(klijent.getOdgovornoLice());
		dto.setPoreskiBroj(klijent.getPoreskiBroj());
		dto.setSifraDelatnosti(klijent.getSifraDelatnosti());
		dto.setTelefon(klijent.getTelefon());
		return dto;
	}
}

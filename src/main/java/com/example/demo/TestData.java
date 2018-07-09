package com.example.demo;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controller.Unmarshalling;
import com.example.demo.model.AnalitikaIzvoda;
import com.example.demo.model.Banka;
import com.example.demo.model.DnevnoStanjeRacuna;
import com.example.demo.model.Drzava;
import com.example.demo.model.Klijent;
import com.example.demo.model.NaseljenoMesto;
import com.example.demo.model.RacuniPravnihLica;
import com.example.demo.model.Valute;
import com.example.demo.model.VrstaPlacanja;
import com.example.demo.service.AnalitikaIzvodaService;
import com.example.demo.service.BankaService;
import com.example.demo.service.DnevnoStanjeRacunaService;
import com.example.demo.service.DrzavaService;
import com.example.demo.service.KlijentService;
import com.example.demo.service.NaseljenoMestoService;
import com.example.demo.service.RacuniPravnihLicaService;
import com.example.demo.service.ValuteService;
import com.example.demo.service.VrstaPlacanjaService;
import com.example.demo.xmlmodel.Uplatnica;

@Component
public class TestData {

	@Autowired
	private AnalitikaIzvodaService analitikaIzvodaService;
	
	@Autowired
	private DrzavaService drzavaService;
	
	@Autowired
	private BankaService bankaService;
	
	@Autowired
	private DnevnoStanjeRacunaService dnevnoStanjeRacunaService;
	
	@Autowired
	private KlijentService klijentService;
	
	@Autowired
	private NaseljenoMestoService naseljenoMestoService;
	
	@Autowired
	private RacuniPravnihLicaService racuniPravnihLicaService;
	
	@Autowired
	private ValuteService valuteService;
	
	@Autowired
	private VrstaPlacanjaService vrstaPlacanjaService;
	
	@PostConstruct
	private void init() {
		/*Unmarshalling unmarshalling = new Unmarshalling();
		unmarshalling.generateClass();*/
		try {
			
			//System.out.println("[INFO] Example 1: JAXB unmarshalling.\n");
			
			// Definiše se JAXB kontekst (putanja do paketa sa JAXB bean-ovima)
			JAXBContext context = JAXBContext.newInstance("com.example.demo.xmlmodel");
			
			// Unmarshaller je objekat zadužen za konverziju iz XML-a u objektni model
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			// Unmarshalling generiše objektni model na osnovu XML fajla 
			Uplatnica uplatnica = (Uplatnica) unmarshaller.unmarshal(new File("./data/uplatnica.xml"));
			
			//System.out.println(uplatnica.getRacunDuznika());
			AnalitikaIzvoda nalog = new AnalitikaIzvoda();
			nalog.setDatumPrijema(uplatnica.getDatumPrijema().toString());
			nalog.setDatumValute(uplatnica.getDatumValute().toString());
			nalog.setDuznikNalogodavac(uplatnica.getPodaciODuzniku().getIme() + " " + uplatnica.getPodaciODuzniku().getPrezime() + " " + uplatnica.getPodaciODuzniku().getAdresa());
			nalog.setHitno(uplatnica.isHitno());
			nalog.setIznos(uplatnica.getIznos().floatValue());
			nalog.setModelOdobrenja(uplatnica.getModelOdobrenja().intValue());
			nalog.setModelZaduzenja(uplatnica.getModelZaduzenja().intValue());
			nalog.setPoverilacPrimalac(uplatnica.getPodaciOPoveriocu().getIme() + " " + uplatnica.getPodaciOPoveriocu().getPrezime() + " " + uplatnica.getPodaciOPoveriocu().getAdresa());
			nalog.setPozivNaBrojOdobrenja(uplatnica.getPozivNaBrojOdobrenja());
			nalog.setPozivNaBrojZaduzenja(uplatnica.getPozivNaBrojZaduzenja());
			nalog.setRacunDuznika(uplatnica.getRacunDuznika());
			nalog.setRacunPoverioca(uplatnica.getRacunPoverioca());
			nalog.setSvrhaPlacanja(uplatnica.getSvrhaPlacanja());
			Drzava drzava = new Drzava(1, "Srbija");
			drzavaService.save(drzava);
			Valute valuta = new Valute("RSD", "dinar", true, drzava);
			valuteService.save(valuta);
			nalog.setValute(valuta);
			NaseljenoMesto naseljenoMesto = new NaseljenoMesto(1, "Ruma", "aa", drzava);
			naseljenoMestoService.save(naseljenoMesto);
			nalog.setNaseljenoMesto(naseljenoMesto);
			VrstaPlacanja vrstaPlacanja = new VrstaPlacanja(1, "lepo placanje");
			vrstaPlacanjaService.save(vrstaPlacanja);
			nalog.setVrstaPlacanja(vrstaPlacanja);
			Klijent klijent = new Klijent(1, "Teodora Brasancevic");
			klijentService.save(klijent);
			Banka banka = new Banka("BI", "pib", "Banka Inteza", "Rumenacka 1", "banka@gmail.com", "banka.com", "111-111", "fax");
			bankaService.save(banka);
			RacuniPravnihLica racun = new RacuniPravnihLica(1l, "999-444-33", "2018-11-11", true, valuta, klijent, banka);
			racuniPravnihLicaService.save(racun);
			DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna(1l, "2018-10-04", 2000, 0, 1000, 1000, racun);
			dnevnoStanjeRacunaService.save(dnevnoStanjeRacuna);
			nalog.setDnevnoStanjeRacuna(dnevnoStanjeRacuna);
			
			System.out.println(nalog.getDatumPrijema());
			System.out.println(nalog.getDatumValute());
			System.out.println(nalog.getDuznikNalogodavac());
			System.out.println(nalog.getIznos());
			System.out.println(nalog.getModelOdobrenja());
			System.out.println(nalog.getModelZaduzenja());
			System.out.println(nalog.getPoverilacPrimalac());
			System.out.println(nalog.getPozivNaBrojOdobrenja());
			System.out.println(nalog.getPozivNaBrojZaduzenja());
			System.out.println(nalog.getRacunDuznika());
			System.out.println(nalog.getRacunPoverioca());
			System.out.println(nalog.getStatus());
			System.out.println(nalog.getSvrhaPlacanja());
			System.out.println(nalog.getTipGreske());
			System.out.println(nalog.isHitno());
			
			analitikaIzvodaService.save(nalog);  
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}

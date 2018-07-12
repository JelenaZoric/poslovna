package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

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
	private void init() throws ParseException {
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
			
			//nalog uplatioca - duznika
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
			String[] tokensDuznik = nalog.getDuznikNalogodavac().split(" ");
			Klijent klijent = new Klijent(tokensDuznik[0] + " " + tokensDuznik[1]);
			klijentService.save(klijent);
			Banka banka = new Banka("BI", "pib", "Banka Inteza", "Rumenacka 1", "banka@gmail.com", "banka.com", "111-111", "fax");
			bankaService.save(banka);
			RacuniPravnihLica racun = new RacuniPravnihLica(nalog.getRacunDuznika(), "2016-11-11", true, valuta, klijent, banka);
			racuniPravnihLicaService.save(racun);
			DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna(2l, nalog.getDatumPrijema(), 0, nalog.getIznos(), racun);
			
			//test primeri za dnevno stanje duznika
			DnevnoStanjeRacuna dnevnoStanjeOdPrekjuce = new DnevnoStanjeRacuna(2l, "2018-10-22", 0, 1000, racun);
			dnevnoStanjeOdPrekjuce.setPredhodnoStanje(5000);
			dnevnoStanjeOdPrekjuce.setNovoStanje(4000);
			dnevnoStanjeRacunaService.save(dnevnoStanjeOdPrekjuce);
			racun.getListaDnevnihStanjaRacuna().add(dnevnoStanjeOdPrekjuce);
			
			DnevnoStanjeRacuna dnevnoStanjeOdJuce = new DnevnoStanjeRacuna(2l, "2018-10-25", 0, 1000, racun);
			dnevnoStanjeOdJuce.setPredhodnoStanje(4000);
			dnevnoStanjeOdJuce.setNovoStanje(3000);
			dnevnoStanjeRacunaService.save(dnevnoStanjeOdJuce);
			racun.getListaDnevnihStanjaRacuna().add(dnevnoStanjeOdJuce);  
			
			System.out.println(racun.getListaDnevnihStanjaRacuna().size());
			if(racun.getListaDnevnihStanjaRacuna().size()==0){
				dnevnoStanjeRacuna.setPredhodnoStanje(0);
			}
			else {
				System.out.println("ima vise dnevnih stanja");
				DnevnoStanjeRacuna staro = new DnevnoStanjeRacuna();
				staro = (DnevnoStanjeRacuna)racun.getListaDnevnihStanjaRacuna().toArray()[0];
				String datumMax = staro.getDatumPrometa();
			//	dnevnoStanjeRacuna.setPredhodnoStanje(staro.getNovoStanje());	*/
				Date date1max=new SimpleDateFormat("yyyy-MM-dd").parse(datumMax);
				DnevnoStanjeRacuna staro1 = new DnevnoStanjeRacuna();
				for (int i = 1; i < racun.getListaDnevnihStanjaRacuna().size(); i++){
					staro1 = (DnevnoStanjeRacuna)racun.getListaDnevnihStanjaRacuna().toArray()[i];
					String datumI = staro1.getDatumPrometa();
					Date date1I=new SimpleDateFormat("yyyy-MM-dd").parse(datumI);
					if(date1I.after(date1max)){
						date1max = date1I;
						datumMax = datumI;
						staro = staro1;
					}
				}
				System.out.println("najveci datum je " + datumMax);
				System.out.println("njegovo stanje je " + staro.getId());
				dnevnoStanjeRacuna.setPredhodnoStanje(staro.getNovoStanje());
			}
			dnevnoStanjeRacuna.setNovoStanje(dnevnoStanjeRacuna.getPredhodnoStanje() - nalog.getIznos());
			dnevnoStanjeRacunaService.save(dnevnoStanjeRacuna);
			nalog.setDnevnoStanjeRacuna(dnevnoStanjeRacuna);
			//racun ima klijenta, dnevno stanje ima racun, nalog ima dnevno stanje!!!
			//klijent ima listu racuna, racun ima listu dnevnih stanja, dnevno stanje ima datum prometa!
			analitikaIzvodaService.save(nalog);  
			
			//nalog primaoca
			AnalitikaIzvoda nalogPrimaoca = new AnalitikaIzvoda();
			nalogPrimaoca.setDatumPrijema(uplatnica.getDatumPrijema().toString());
			nalogPrimaoca.setDatumValute(uplatnica.getDatumValute().toString());
			nalogPrimaoca.setDuznikNalogodavac(uplatnica.getPodaciODuzniku().getIme() + " " + uplatnica.getPodaciODuzniku().getPrezime() + " " + uplatnica.getPodaciODuzniku().getAdresa());
			nalogPrimaoca.setHitno(uplatnica.isHitno());
			nalogPrimaoca.setIznos(uplatnica.getIznos().floatValue());
			nalogPrimaoca.setModelOdobrenja(uplatnica.getModelOdobrenja().intValue());
			nalogPrimaoca.setModelZaduzenja(uplatnica.getModelZaduzenja().intValue());
			nalogPrimaoca.setPoverilacPrimalac(uplatnica.getPodaciOPoveriocu().getIme() + " " + uplatnica.getPodaciOPoveriocu().getPrezime() + " " + uplatnica.getPodaciOPoveriocu().getAdresa());
			nalogPrimaoca.setPozivNaBrojOdobrenja(uplatnica.getPozivNaBrojOdobrenja());
			nalogPrimaoca.setPozivNaBrojZaduzenja(uplatnica.getPozivNaBrojZaduzenja());
			nalogPrimaoca.setRacunDuznika(uplatnica.getRacunDuznika());
			nalogPrimaoca.setRacunPoverioca(uplatnica.getRacunPoverioca());
			nalogPrimaoca.setSvrhaPlacanja(uplatnica.getSvrhaPlacanja());
			nalogPrimaoca.setValute(valuta);
			nalogPrimaoca.setNaseljenoMesto(naseljenoMesto);
			nalogPrimaoca.setVrstaPlacanja(vrstaPlacanja);
			String[] tokens = nalog.getPoverilacPrimalac().split(" ");
			Klijent klijentPrimalac = new Klijent(tokens[0] + " " + tokens[1]);
			klijentService.save(klijentPrimalac);
			RacuniPravnihLica racunPrimaoca = new RacuniPravnihLica(nalogPrimaoca.getRacunPoverioca(), "2017-06-01", valuta);
			racunPrimaoca.setBanka(banka);
			racunPrimaoca.setKlijent(klijentPrimalac);
			racunPrimaoca.setVazeci(true);
			racuniPravnihLicaService.save(racunPrimaoca);
			DnevnoStanjeRacuna stanjePrimaoca = new DnevnoStanjeRacuna(1l, "2018-07-11", nalogPrimaoca.getIznos(), 0, racunPrimaoca);
			
			//test primeri za dnevno stanje primaoca
			DnevnoStanjeRacuna dnevnoStanjeOdPrekjuceP = new DnevnoStanjeRacuna(2l, "2018-10-22", 1000, 0, racunPrimaoca);
			dnevnoStanjeOdPrekjuceP.setPredhodnoStanje(8000);
			dnevnoStanjeOdPrekjuceP.setNovoStanje(9000);
			dnevnoStanjeRacunaService.save(dnevnoStanjeOdPrekjuceP);
			racunPrimaoca.getListaDnevnihStanjaRacuna().add(dnevnoStanjeOdPrekjuceP);
			
			DnevnoStanjeRacuna dnevnoStanjeOdJuceP = new DnevnoStanjeRacuna(2l, "2018-10-25", 2000, 0, racunPrimaoca);
			dnevnoStanjeOdJuceP.setPredhodnoStanje(9000);
			dnevnoStanjeOdJuceP.setNovoStanje(11000);
			dnevnoStanjeRacunaService.save(dnevnoStanjeOdJuceP);
			racunPrimaoca.getListaDnevnihStanjaRacuna().add(dnevnoStanjeOdJuceP);
			
			System.out.println(racunPrimaoca.getListaDnevnihStanjaRacuna().size());
			if(racunPrimaoca.getListaDnevnihStanjaRacuna().size()==0){
				stanjePrimaoca.setPredhodnoStanje(0);
			}
			else {
				System.out.println("ima vise dnevnih stanja");
				DnevnoStanjeRacuna staroPrimalac = new DnevnoStanjeRacuna();
				staroPrimalac = (DnevnoStanjeRacuna)racunPrimaoca.getListaDnevnihStanjaRacuna().toArray()[0];
				String datumMaxPrimalac = staroPrimalac.getDatumPrometa();
				Date date1maxPrimalac=new SimpleDateFormat("yyyy-MM-dd").parse(datumMaxPrimalac);
				DnevnoStanjeRacuna novo = new DnevnoStanjeRacuna();
				for (int i = 1; i < racunPrimaoca.getListaDnevnihStanjaRacuna().size(); i++){
					novo = (DnevnoStanjeRacuna)racunPrimaoca.getListaDnevnihStanjaRacuna().toArray()[i];
					String datumNovi = novo.getDatumPrometa();
					Date dateNovo=new SimpleDateFormat("yyyy-MM-dd").parse(datumNovi);
					if(dateNovo.after(date1maxPrimalac)){
						date1maxPrimalac = dateNovo;
						datumMaxPrimalac = datumNovi;
						staroPrimalac = novo;
					}
				}
				System.out.println("najveci datum je " + datumMaxPrimalac);
				System.out.println("njegovo stanje je " + staroPrimalac.getId());
				stanjePrimaoca.setPredhodnoStanje(staroPrimalac.getNovoStanje());
			}
			stanjePrimaoca.setNovoStanje(stanjePrimaoca.getPredhodnoStanje() + nalogPrimaoca.getIznos());
			dnevnoStanjeRacunaService.save(stanjePrimaoca);
			nalogPrimaoca.setDnevnoStanjeRacuna(stanjePrimaoca);
			analitikaIzvodaService.save(nalogPrimaoca);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		//exportToPdf();
	}
	
	public void exportToPdf(){
		try {
			java.sql.Connection conn = DriverManager.getConnection ("jdbc:h2:mem:poslovna", "sa","");
			JasperPrint jp = JasperFillManager.fillReport(
			getClass().getResource("./data/IzvodKlijenta.jasper").openStream(),
			new HashMap<String, Object>(), conn);
			//eksport
			File pdf = File.createTempFile("output.", ".pdf");
			JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
		}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
}

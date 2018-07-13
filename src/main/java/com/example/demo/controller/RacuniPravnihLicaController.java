package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Banka;
import com.example.demo.model.DnevnoStanjeRacuna;
import com.example.demo.model.Klijent;
import com.example.demo.model.RacunDTO;
import com.example.demo.model.RacuniPravnihLica;
import com.example.demo.model.Valute;
import com.example.demo.service.BankaService;
import com.example.demo.service.DnevnoStanjeRacunaService;
import com.example.demo.service.KlijentService;
import com.example.demo.service.RacuniPravnihLicaService;
import com.example.demo.service.ValuteService;

@RestController
@RequestMapping(value = "/racuni")
public class RacuniPravnihLicaController {

	@Autowired
	private RacuniPravnihLicaService racuniPravnihLicaService;
	
	@Autowired
	private DnevnoStanjeRacunaService dnevnoStanjeRacunaService;
	
	@Autowired
	private KlijentService klijentService;
	
	@Autowired
	private ValuteService valuteService;
	
	@Autowired
	private BankaService bankaService;
	
	@RequestMapping(value="/getRacuni", method=RequestMethod.GET)
	public ResponseEntity<List<RacuniPravnihLica>> getRacuni(){
		List<RacuniPravnihLica> racuni = racuniPravnihLicaService.findAll();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getRacun/{id}", method = RequestMethod.GET)
	public ResponseEntity<RacuniPravnihLica> getRacun(@PathVariable Long id){
	    RacuniPravnihLica r = racuniPravnihLicaService.findOne(id);
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
	
	//za next iz tabele klijenata
	@RequestMapping(value="/getRacuni/{id}", method=RequestMethod.GET)
	public ResponseEntity<Set<RacuniPravnihLica>> getRacuniNext(@PathVariable Long id){
		Klijent k = klijentService.findOne(id);
		Set<RacuniPravnihLica> racuni = k.getListaRacunaPravnihLica();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
	
	//za next iz tabele valuta
	@RequestMapping(value="/getRacuni2/{id}", method=RequestMethod.GET)
	public ResponseEntity<Set<RacuniPravnihLica>> getRacuniNext2(@PathVariable Long id){
		Valute v = valuteService.findOne(id);
		Set<RacuniPravnihLica> racuni = v.getListaRacunaPravnihLica();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
	
	//za next iz tabele banki
	@RequestMapping(value="/getRacuni3/{id}", method=RequestMethod.GET)
	public ResponseEntity<Set<RacuniPravnihLica>> getRacuniNext3(@PathVariable Long id){
		Banka b = bankaService.findOne(id);
		Set<RacuniPravnihLica> racuni = b.getListaRacunaPravnihLica();
		return new ResponseEntity<>(racuni, HttpStatus.OK);		
	}
		
	@RequestMapping(value="/dodajRacun", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RacuniPravnihLica> dodajKlijenta(@RequestBody RacunDTO racun){
		Klijent k = klijentService.findOne(racun.getKlijent());
		Valute v = valuteService.findOne(racun.getValute());
		Banka b = bankaService.findOne(racun.getBanka());
		RacuniPravnihLica r = new RacuniPravnihLica(racun.getBrojRacuna(), 
				racun.getDatumOtvaranja(), true, v, k, b);
		racuniPravnihLicaService.save(r);
		return new ResponseEntity<>(r, HttpStatus.OK);		
	}
	@RequestMapping(value="/izmeniRacun/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RacuniPravnihLica> izmeniRacun(@RequestBody RacunDTO racun, @PathVariable Long id){
        RacuniPravnihLica r = racuniPravnihLicaService.findOne(id);
        Klijent k = klijentService.findOne(r.getKlijent().getId());
        Valute valute = valuteService.findOne(racun.getValute());
        RacuniPravnihLica edit = new RacuniPravnihLica(racun.getBrojRacuna(), 
				racun.getDatumOtvaranja(), valute);
		
		r.setBrojRacuna(edit.getBrojRacuna());
		r.setDatumOtvaranja(edit.getDatumOtvaranja());
		r.setKlijent(k);
		r.setValute(edit.getValute());
		racuniPravnihLicaService.save(r);
		return new ResponseEntity<>(r, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/aktiviraj/{id}", method = RequestMethod.GET)
	public ResponseEntity<RacuniPravnihLica> aktiviraj(@PathVariable Long id) {
		RacuniPravnihLica aktiviran = racuniPravnihLicaService.findOne(id);
		aktiviran.setVazeci(true);
		racuniPravnihLicaService.save(aktiviran);
	 return new ResponseEntity<>(aktiviran, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deaktiviraj/{id}/{brAkt}", method=RequestMethod.GET)
	public ResponseEntity<RacuniPravnihLica> deaktiviraj(@PathVariable Long id, @PathVariable String brAkt) throws ParseException{
		System.out.println("usao u metodu");
		RacuniPravnihLica deaktiviran = racuniPravnihLicaService.findOne(id);
		deaktiviran.setVazeci(false);
		
		DnevnoStanjeRacuna staroStanje = new DnevnoStanjeRacuna();
		if(deaktiviran.getListaDnevnihStanjaRacuna().size()==0){
			racuniPravnihLicaService.save(deaktiviran);
			return new ResponseEntity<>(deaktiviran, HttpStatus.OK);
		}
		staroStanje = (DnevnoStanjeRacuna)deaktiviran.getListaDnevnihStanjaRacuna().toArray()[0];
		String datumMax1 = staroStanje.getDatumPrometa();
		DnevnoStanjeRacuna stanjeZaDeakt = new DnevnoStanjeRacuna();
		Date datemax=new SimpleDateFormat("yyyy-MM-dd").parse(datumMax1);
		for (int i = 1; i < deaktiviran.getListaDnevnihStanjaRacuna().size(); i++){
			stanjeZaDeakt = (DnevnoStanjeRacuna)deaktiviran.getListaDnevnihStanjaRacuna().toArray()[i];
			String datumI = stanjeZaDeakt.getDatumPrometa();
			Date date1I=new SimpleDateFormat("yyyy-MM-dd").parse(datumI);
			if(date1I.after(datemax)){
				datemax = date1I;
				datumMax1 = datumI;
				staroStanje = stanjeZaDeakt;
			}
		}
		
		
		
		System.out.println(deaktiviran.getKlijent().getNazivKlijenta() + " njen racun se deaktivira");
		DnevnoStanjeRacuna stanjeZaAkt = new DnevnoStanjeRacuna();
		List<RacuniPravnihLica> sviRacuni = racuniPravnihLicaService.findAll();
		RacuniPravnihLica aktivanRacun = new RacuniPravnihLica();   
		for(int i = 0; i < sviRacuni.size(); i++){
			if(sviRacuni.get(i).getBrojRacuna().equals(brAkt)){
				aktivanRacun = sviRacuni.get(i);
				//sviRacuni.get(i).getListaDnevnihStanjaRacuna().add(stanjeZaAkt);
			}
		}  
		System.out.println(aktivanRacun.getKlijent().getNazivKlijenta() + " na njen racun idu pare");
		
		if(aktivanRacun.getListaDnevnihStanjaRacuna().size()==0){
			stanjeZaAkt.setPredhodnoStanje(0);
		}
		else {   
			System.out.println("ima vise dnevnih stanja");
			DnevnoStanjeRacuna staro = new DnevnoStanjeRacuna();
			staro = (DnevnoStanjeRacuna)aktivanRacun.getListaDnevnihStanjaRacuna().toArray()[0];
			String datumMax = staro.getDatumPrometa();
			//stanjeZaAkt.setPredhodnoStanje(staro.getNovoStanje());	
			Date date1max=new SimpleDateFormat("yyyy-MM-dd").parse(datumMax);
			DnevnoStanjeRacuna staro1 = new DnevnoStanjeRacuna();
			for (int i = 1; i < aktivanRacun.getListaDnevnihStanjaRacuna().size(); i++){
				staro1 = (DnevnoStanjeRacuna)aktivanRacun.getListaDnevnihStanjaRacuna().toArray()[i];
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
			stanjeZaAkt.setPredhodnoStanje(staro.getNovoStanje());  
		}  
		stanjeZaAkt.setNovoStanje(stanjeZaAkt.getPredhodnoStanje() + staroStanje.getNovoStanje());
		stanjeZaAkt.setBrojIzvoda(3l);
		stanjeZaAkt.setDatumPrometa("2018-12-12");
		stanjeZaAkt.setPrometNaTeret(0);
		stanjeZaAkt.setPrometUKorist(staroStanje.getNovoStanje());
		stanjeZaAkt.setRacuniPravnihLica(aktivanRacun);
		dnevnoStanjeRacunaService.save(stanjeZaAkt);
		
		
	//	aktivanRacun.getListaDnevnihStanjaRacuna().add(stanjeZaAkt);
		return new ResponseEntity<>(deaktiviran, HttpStatus.OK);		
	}
}

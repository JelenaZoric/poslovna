package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AnalitikaIzvoda;
import com.example.demo.model.AnalitikeIzvoda;
import com.example.demo.model.DnevnoStanjeRacuna;
import com.example.demo.model.Klijent;
import com.example.demo.model.dto.AnalitikaIzvodaDTO;
import com.example.demo.model.dto.Converters;
import com.example.demo.model.dto.KlijentDTO;
import com.example.demo.service.AnalitikaIzvodaService;
import com.example.demo.model.RacuniPravnihLica;
import com.example.demo.service.KlijentService;
import com.example.demo.service.RacuniPravnihLicaService;

@RestController
@RequestMapping(value = "/klijenti")
public class KlijentController {

	@Autowired
	private KlijentService klijentService;
	
	@Autowired
	private AnalitikaIzvodaService analitikaIzvodaService;

	@Autowired
	private RacuniPravnihLicaService racuniPravnihLicaService;
	
	@RequestMapping(value="/getKlijenti", method=RequestMethod.GET)
	public ResponseEntity<List<Klijent>> getKlijenti(){
		List<Klijent> klijenti = klijentService.findAll();
		return new ResponseEntity<>(klijenti, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/dodajKlijenta", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Klijent> dodajKlijenta(@RequestBody Klijent klijent){
		System.out.println("TO STRING -- " + klijent.toString());
		Klijent k = new Klijent(klijent.getNazivKlijenta(), klijent.getMesto(), klijent.getAdresa(),
				klijent.getTelefon(), klijent.getFaks(), klijent.getEmail(), klijent.getJmbg(), klijent.getOdgovornoLice(),
				klijent.getNazivDelatnosti(), klijent.getSifraDelatnosti(), klijent.getNadlezniPoreskiOrgan(), klijent.getPoreskiBroj(), true);
		klijentService.save(k);
		return new ResponseEntity<>(k, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getKlijenta/{id}", method = RequestMethod.GET)
	public ResponseEntity<Klijent> getKlijenta(@PathVariable Long id){
		Klijent k = klijentService.findOne(id);
		return new ResponseEntity<>(k, HttpStatus.OK);
	}
	
	@RequestMapping(value="/izmeniKlijenta/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Klijent> izmeniKlijenta(@PathVariable Long id, @RequestBody Klijent klijent) {
		Klijent k = klijentService.findOne(id);
		k.setNazivKlijenta(klijent.getNazivKlijenta());
		k.setAdresa(klijent.getAdresa());
		k.setMesto(klijent.getMesto());
		k.setTelefon(klijent.getTelefon());
		k.setFaks(klijent.getFaks());
		k.setEmail(klijent.getEmail());
		k.setJmbg(klijent.getJmbg());
		k.setNadlezniPoreskiOrgan(klijent.getNadlezniPoreskiOrgan());
		k.setNazivDelatnosti(klijent.getNazivDelatnosti());
		k.setSifraDelatnosti(klijent.getSifraDelatnosti());
		k.setPoreskiBroj(klijent.getPoreskiBroj());
		k.setOdgovornoLice(klijent.getOdgovornoLice());
		klijentService.save(k);
		return new ResponseEntity<>(k, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Klijent> deaktiviraj(@PathVariable Long id) {
		Klijent deaktiviran = klijentService.delete(id);
	 return new ResponseEntity<>(deaktiviran, HttpStatus.OK);
	}
	
	@RequestMapping(value="/export", method=RequestMethod.GET)
	public void exportToPdf(@RequestParam("id") Long id){
		try {
			Class.forName ("com.mysql.jdbc.Driver").newInstance(); 
			java.sql.Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/demo", "root", "isa1");
			ClassLoader classLoader = getClass().getClassLoader();
			//System.out.println(classLoader.getResource("jasper/IzvodKlijenta.jasper"));
			/*String path = "C://Users/Zorija/Desktop";
			String filename = "report";
			Map parameters = new HashMap(); 
			JasperCompileManager.compileReportToFile(path + filename + ".jrxml");
			JasperFillManager.fillReportToFile(path+filename+".jasper", parameters, new JREmptyDataSource());
			*/
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("id_klijenta",id);
			JasperPrint jp = new JasperPrint();
			jp = JasperFillManager.fillReport(
			classLoader.getResource("jasper/IzvodKlijenta.jasper").openStream(),
			parameters, conn); 
			/*
			File file = new File("C:\\Users\\Zorija\\Desktop\\IzvodKlijenta.jasper");
			System.out.println("napravio fajl");
			FileInputStream fis = new FileInputStream(file);
			System.out.println("inout stream");
			*/
			/*JasperPrint jp = JasperFillManager.fillReport(
					(InputStream)fis,
					new HashMap<>(), conn);*/
			//eksport
			File pdf = File.createTempFile("izvod.", ".pdf");
			JasperExportManager.exportReportToPdfFile(jp, "izvod.pdf");
		}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	
	@RequestMapping(value="xmlexport", method=RequestMethod.GET)
	public void exportToXml(@RequestParam("id") Long id) {
		/*AnalitikaIzvoda upl = analitikaIzvodaService.findOne(2l);
		AnalitikaIzvodaDTO dto = Converters.convertAnalitikaIzvodaToAnalitikaIzvodaDTO(upl);
		System.out.println(upl.getDuznikNalogodavac());*/
		Klijent klijent = klijentService.findOne(id);
		if(klijent != null) {
			Set<RacuniPravnihLica> racuni = klijent.getListaRacunaPravnihLica();
			AnalitikeIzvoda listaAnalitika = new AnalitikeIzvoda();
			for(RacuniPravnihLica racun : racuni) {
				for(DnevnoStanjeRacuna dnevnoStanje : racun.getListaDnevnihStanjaRacuna()) {
					for(AnalitikaIzvoda analitika : dnevnoStanje.getListaAnalitikeIzvoda()) {
						AnalitikaIzvodaDTO dto = Converters.convertAnalitikaIzvodaToAnalitikaIzvodaDTO(analitika);
						listaAnalitika.dodajAnalitiku(dto);
					}
				}
			}
			File file = new File("izvod.xml");
			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(AnalitikeIzvoda.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
				jaxbMarshaller.marshal(listaAnalitika, file);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package com.example.demo.controller;

import java.io.File;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.model.Banka;
import com.example.demo.service.BankaService;

@RestController
@RequestMapping(value = "/banke")
public class BankaController {

	@Autowired
	private BankaService bankaService;
	
	@RequestMapping(value="/getBanke", method=RequestMethod.GET)
	public ResponseEntity<List<Banka>> getValute(){
		List<Banka> banka = bankaService.findAll();
		return new ResponseEntity<>(banka, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getBanka/{id}", method = RequestMethod.GET)
	public ResponseEntity<Banka> getBanka(@PathVariable Long id){
		Banka b = bankaService.findOne(id);
		return new ResponseEntity<>(b, HttpStatus.OK);
	}
	
	@RequestMapping(value="/dodajBanku", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Banka> dodajBanka(@RequestBody Banka banka){
		Banka b = new Banka(banka.getSifraBanke(),  banka.getPib(), banka.getNaziv(), banka.getAdresa(),
				banka.getEmail(), banka.getWeb(), banka.getTelefon(), banka.getFax());
		bankaService.save(b);
		return new ResponseEntity<>(b, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/izmeniBanku/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Banka> izmeniBanka(@RequestBody Banka banka, @PathVariable Long id){
		Banka b = bankaService.findOne(id);
		b.setAdresa(banka.getAdresa());
		b.setEmail(banka.getEmail());
		b.setFax(banka.getFax());
		b.setTelefon(banka.getTelefon());
		b.setSifraBanke(banka.getSifraBanke());
		b.setWeb(banka.getWeb());
		b.setPib(banka.getPib());
		b.setNaziv(banka.getNaziv());
		bankaService.save(b);
		return new ResponseEntity<>(b, HttpStatus.OK);		
	}
	
	//prilikom brisanja banke brisu se i svi njeni racuni automatski
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Banka> obrisiBanku(@PathVariable Long id) {
		Banka b = bankaService.delete(id);
	 return new ResponseEntity<>(b, HttpStatus.OK);
	}
	
	@RequestMapping(value="/export", method=RequestMethod.GET)
	public void exportToPdf() {
		try {
			Class.forName ("com.mysql.jdbc.Driver").newInstance(); 
			java.sql.Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/demo", "root", "isa1");
			ClassLoader classLoader = getClass().getClassLoader();
			JasperPrint jp = new JasperPrint();
			jp = JasperFillManager.fillReport(
			classLoader.getResource("jasper/StanjeRacuna.jasper").openStream(),
			null, conn); 
			//eksport
			File pdf = File.createTempFile("banka.", ".pdf");
			JasperExportManager.exportReportToPdfFile(jp, "banka.pdf");
		}catch (Exception ex) {
				ex.printStackTrace();
			}
	}
}

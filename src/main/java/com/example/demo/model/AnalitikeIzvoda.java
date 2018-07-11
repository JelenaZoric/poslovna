package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.example.demo.model.dto.AnalitikaIzvodaDTO;

@XmlRootElement(name="izvod")
public class AnalitikeIzvoda {

	private List<AnalitikaIzvodaDTO> analitike = new ArrayList<AnalitikaIzvodaDTO>();
	
	public void setAnalitike(List<AnalitikaIzvodaDTO> analitike) {
		this.analitike = analitike;
	}

	@XmlElements(value = { @XmlElement (name = "analitika_izvoda", type = AnalitikaIzvodaDTO.class)})
    @XmlElementWrapper
    public List<AnalitikaIzvodaDTO> getAnalitike() {
        return analitike;
    }

    public void dodajAnalitiku(AnalitikaIzvodaDTO analitika) {
        analitike.add(analitika);
    }
}

package com.example.demo.model.dto;

import java.io.Serializable;

public class DrzavaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7048397022428373569L;
	
	private Long id;
	private int sifraDrzave;
	private String nazivDrzave;
	
	public DrzavaDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getSifraDrzave() {
		return sifraDrzave;
	}
	
	public void setSifraDrzave(int sifraDrzave) {
		this.sifraDrzave = sifraDrzave;
	}
	
	public String getNazivDrzave() {
		return nazivDrzave;
	}
	
	public void setNazivDrzave(String nazivDrzave) {
		this.nazivDrzave = nazivDrzave;
	}
}

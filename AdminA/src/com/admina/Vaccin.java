package com.admina;

import java.io.Serializable;



public class Vaccin implements Serializable {
	
	private int idvaccin;
	private String nomvaccin ;
	private String datevaccin ;
	
	public Vaccin(int idvaccin, String nomvaccin, String datevaccin) {
		super();
		this.idvaccin = idvaccin;
		this.nomvaccin = nomvaccin;
		this.datevaccin = datevaccin;
	}

	public int getIdvaccin() {
		return idvaccin;
	}

	public void setIdvaccin(int idvaccin) {
		this.idvaccin = idvaccin;
	}

	public String getNomvaccin() {
		return nomvaccin;
	}

	public void setNomvaccin(String nomvaccin) {
		this.nomvaccin = nomvaccin;
	}

	public String getDatevaccin() {
		return datevaccin;
	}

	public void setDatevaccin(String datevaccin) {
		this.datevaccin = datevaccin;
	}
	
	

}

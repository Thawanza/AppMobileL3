package com.admina;

public class RendezVous {
	
	private int idrdv ;
	private String nomuser ,daterdv , typeprelevement  , listeanalyse , heurerdv , adresse ;
	
	
	public RendezVous(int idrdv, String nomuser, String daterdv,
			String typeprelevement, String listeanalyse, String heurerdv,
			String adresse) {
		super();
		this.idrdv = idrdv;
		this.nomuser = nomuser;
		this.daterdv = daterdv;
		this.typeprelevement = typeprelevement;
		this.listeanalyse = listeanalyse;
		this.heurerdv = heurerdv;
		this.adresse = adresse;
	}


	public int getIdrdv() {
		return idrdv;
	}


	public void setIdrdv(int idrdv) {
		this.idrdv = idrdv;
	}


	public String getNomuser() {
		return nomuser;
	}


	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}


	public String getDaterdv() {
		return daterdv;
	}


	public void setDaterdv(String daterdv) {
		this.daterdv = daterdv;
	}


	public String getTypeprelevement() {
		return typeprelevement;
	}


	public void setTypeprelevement(String typeprelevement) {
		this.typeprelevement = typeprelevement;
	}


	public String getListeanalyse() {
		return listeanalyse;
	}


	public void setListeanalyse(String listeanalyse) {
		this.listeanalyse = listeanalyse;
	}


	public String getHeurerdv() {
		return heurerdv;
	}


	public void setHeurerdv(String heurerdv) {
		this.heurerdv = heurerdv;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	

}

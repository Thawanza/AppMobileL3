package com.admina;

public class Patient {
	private int id ;
	private String numerodetelephone , user , motdepasse , age , sexe ;
	
	public Patient(int id, String numerodetelephone, String user,
			String motdepasse, String age, String sexe) {
		super();
		this.id = id;
		this.numerodetelephone = numerodetelephone;
		this.user = user;
		this.motdepasse = motdepasse;
		this.age = age;
		this.sexe = sexe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumerodetelephone() {
		return numerodetelephone;
	}

	public void setNumerodetelephone(String numerodetelephone) {
		this.numerodetelephone = numerodetelephone;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
	
	
}

package com.alioune.model;

import java.util.ArrayList;
import java.util.List;

import com.alioune.entities.Langage;

public class DeveloperDto {
	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private List<Langage> langs = new ArrayList<Langage>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Langage> getLangs() {
		return langs;
	}

	public void setLangs(List<Langage> langs) {
		this.langs = langs;
	}

}

package com.alioune.model;

import java.util.ArrayList;
import java.util.List;

import com.alioune.entities.Developer;

public class LangageDto {
	private String id;
	private String libelle;
	private List<Developer> developers = new ArrayList<Developer>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

}

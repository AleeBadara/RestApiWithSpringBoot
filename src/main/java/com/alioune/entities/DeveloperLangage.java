package com.alioune.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_txn_developer_langage")
public class DeveloperLangage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "id_dev", columnDefinition = "char(36)")
	private String idDev;

	@Column(name = "id_lang", columnDefinition = "char(36)")
	private String idLang;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdDev() {
		return idDev;
	}

	public void setIdDev(String idDev) {
		this.idDev = idDev;
	}

	public String getIdLang() {
		return idLang;
	}

	public void setIdLang(String idLang) {
		this.idLang = idLang;
	}

}

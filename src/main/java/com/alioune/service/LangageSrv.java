package com.alioune.service;

import java.util.List;

import com.alioune.entities.Langage;

public interface LangageSrv {

	/**
	 * Sauvegarde un ou des langage(s) en base
	 * 
	 * @param langs
	 * @return
	 */
	List<Langage> add(List<Langage> langs);

	/**
	 * Récupére un langage par son identifiant
	 * 
	 * @param id
	 * @return
	 */
	Langage findById(String id);

	/**
	 * Récupére les langages avec le libellé passé en paramétre
	 * 
	 * @param lib
	 * @return
	 */
	List<Langage> findByLibelle(String lib);

	List<Langage> getAll();

}

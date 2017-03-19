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
	List<Langage> addLangage(List<Langage> langs);

	/**
	 * Récupére un langage par son identifiant
	 * 
	 * @param id
	 *            identifiant du langage
	 * @return
	 */
	Langage findById(String id);

	/**
	 * Récupére les langages avec le libellé passé en paramétre
	 * 
	 * @param lib
	 *            libellé du langage rechercé
	 * @return collection correspondant à la recherche
	 */
	List<Langage> findByLibelle(String lib);

	/**
	 * Renvoie tous les langages
	 * 
	 * @return
	 */
	List<Langage> getAll();

}

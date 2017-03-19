package com.alioune.service;

import java.util.List;

import com.alioune.entities.Developer;
import com.alioune.model.DeveloperDto;

public interface DeveloperSrv {

	/**
	 * Sauvegarde un ou des développeur(s) en bdd
	 * 
	 * @param dev
	 * @return
	 */
	List<Developer> addDeveloper(List<Developer> devs);

	/**
	 * Met à jour les informations d'un développeur
	 * 
	 * @param devToUpdate
	 * @return
	 */
	Developer updateDeveloper(Developer devToUpdate);

	/**
	 * Récupére les développeurs ayant une compétence sur un langage par le
	 * libellé du langage
	 * 
	 * @param libLangage
	 * @return
	 */
	List<DeveloperDto> findDevByLibelleLangage(String libLangage);

	/**
	 * Récupére les développeurs ayant une compétence sur un langage par
	 * l'identifiant du langage
	 * 
	 * @param idLangage
	 * @return
	 */
	List<DeveloperDto> findDevByIdLangage(String idLangage);

	/**
	 * Récupére tous les développeurs
	 * 
	 * @return
	 */
	List<DeveloperDto> findAll();

	/**
	 * Recherche un développeur en fonction de son identifiant
	 * 
	 * @param idDev
	 *            identifiant du développeur recherché
	 * @return
	 */
	Developer findDeveloperById(String idDev);
}

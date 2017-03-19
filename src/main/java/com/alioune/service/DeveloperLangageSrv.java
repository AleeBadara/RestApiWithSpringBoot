package com.alioune.service;

import com.alioune.entities.DeveloperLangage;

public interface DeveloperLangageSrv {
	/**
	 * Associe un développeur à un langage
	 * 
	 * @param idDev
	 *            identifiant du développeur
	 * @param idLang
	 *            identifiant du langage
	 * @return l'objet de l'association
	 */
	DeveloperLangage associateDevToALangage(String idDev, String idLang);
}

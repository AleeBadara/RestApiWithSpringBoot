package com.alioune.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alioune.entities.DeveloperLangage;

@Repository
public interface DeveloperLangageRepository extends CrudRepository<DeveloperLangage, Integer> {

	/**
	 * Récupére les identifiants des développeurs d'un langage
	 * 
	 * @param idLang
	 * @return
	 */
	List<DeveloperLangage> findByIdLang(String idLang);

	/**
	 * Récupére les identifiants des langages d'un développeur
	 * 
	 * @param idDev
	 * @return
	 */
	List<DeveloperLangage> findByIdDev(String idDev);

}

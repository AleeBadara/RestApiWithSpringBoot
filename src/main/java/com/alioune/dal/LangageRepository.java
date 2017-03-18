package com.alioune.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alioune.entities.Langage;

@Repository
public interface LangageRepository extends CrudRepository<Langage, String> {

	/**
	 * Recherche les langages par libellé
	 * 
	 * @param libelle
	 * @return
	 */
	List<Langage> findByLibelleContainingIgnoreCase(String libelle);

}
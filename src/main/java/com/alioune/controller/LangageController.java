package com.alioune.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alioune.entities.Langage;
import com.alioune.service.LangageSrv;
import com.alioune.utils.Constantes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Opérations sur le langage")
@RestController
@RequestMapping("/api/langage")
public class LangageController {
	@Autowired
	private LangageSrv langageSrv;

	@ApiOperation(value = "Permet d'ajouter un langage")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "addLang", method = RequestMethod.POST)
	public ResponseEntity<List<Langage>> addLangage(@RequestBody List<Langage> langs) {
		List<Langage> results;
		for (Langage lang : langs) {
			lang.setId(UUID.randomUUID().toString());
		}
		try {
			results = langageSrv.addLangage(langs);
		} catch (Exception e) {
			return new ResponseEntity(Constantes.ADD_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Langage>>(results, HttpStatus.OK);
	}

	@ApiOperation(value = "Renvoie tous les langages")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Langage>> getAllLangages() {
		List<Langage> results;
		try {
			results = langageSrv.getAll();
		} catch (Exception e) {
			return new ResponseEntity(Constantes.SEARCH_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (results == null || results.isEmpty()) {
			return new ResponseEntity(Constantes.NORESULTS, HttpStatus.OK);
		}
		return new ResponseEntity<List<Langage>>(results, HttpStatus.OK);
	}

}

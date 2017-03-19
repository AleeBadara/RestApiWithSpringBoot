package com.alioune.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alioune.entities.Developer;
import com.alioune.entities.DeveloperLangage;
import com.alioune.entities.Langage;
import com.alioune.service.DeveloperLangageSrv;
import com.alioune.service.DeveloperSrv;
import com.alioune.service.LangageSrv;
import com.alioune.utils.Constantes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Association de développeur à un langage")
@RestController
@RequestMapping("/api/devLang")
public class DeveloperLangageController {

	@Autowired
	private DeveloperLangageSrv developerLangageSrv;
	@Autowired
	private DeveloperSrv developerSrv;
	@Autowired
	private LangageSrv langageSrv;

	@ApiOperation(value = "Permet d'associer un langage à un développeur")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "associateDeveloperToALangage", method = RequestMethod.GET)
	public ResponseEntity<DeveloperLangage> addDeveloper(@RequestParam(name = "idDev") String idDev,
			@RequestParam(name = "idLang") String idLang) {
		Developer dev = developerSrv.findDeveloperById(idDev);
		Langage lang = langageSrv.findById(idLang);
		if (dev == null || lang == null) {
			return new ResponseEntity(Constantes.INCORRECT_ID, HttpStatus.OK);
		}
		DeveloperLangage result;
		try {
			result = developerLangageSrv.associateDevToALangage(idDev, idLang);
		} catch (Exception e) {
			return new ResponseEntity(Constantes.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<DeveloperLangage>(result, HttpStatus.OK);
	}

}

package com.alioune.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alioune.entities.DeveloperLangage;
import com.alioune.service.DeveloperLangageSrv;
import com.alioune.utils.Constantes;

@RestController
@RequestMapping("/api/devLang")
public class DeveloperLangageController {

	@Autowired
	private DeveloperLangageSrv developerLangageSrv;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "associateDeveloperToALangage", method = RequestMethod.GET)
	public ResponseEntity<DeveloperLangage> addDeveloper(@RequestParam(name = "idDev") String idDev,
			@RequestParam(name = "idLang") String idLang) {
		DeveloperLangage result;
		try {
			result = developerLangageSrv.associateDevToALangage(idDev, idLang);
		} catch (Exception e) {
			return new ResponseEntity(Constantes.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<DeveloperLangage>(result, HttpStatus.OK);
	}

}

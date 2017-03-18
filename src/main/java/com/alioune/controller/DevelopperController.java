package com.alioune.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alioune.entities.Developer;
import com.alioune.model.DeveloperDto;
import com.alioune.service.DeveloperSrv;
import com.alioune.utils.Constantes;

@RestController
@RequestMapping("/api/developer")
public class DevelopperController {
	@Autowired
	private DeveloperSrv developerSrv;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "addDev", method = RequestMethod.POST)
	public ResponseEntity<List<Developer>> addDeveloper(@RequestBody List<Developer> devs) {
		List<Developer> results;
		for (Developer dev : devs) {
			dev.setId(UUID.randomUUID().toString());
		}
		try {
			results = developerSrv.addDeveloper(devs);
		} catch (Exception e) {
			return new ResponseEntity(Constantes.ADD_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Developer>>(results, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "findDeveloperByLibelleLang", method = RequestMethod.GET)
	public ResponseEntity<List<DeveloperDto>> findDevByLibelleLangage(
			@RequestParam(name = "libLang") String libelleLangage) {
		List<DeveloperDto> results = developerSrv.findDevByLibelleLangage(libelleLangage);
		if (results == null || results.size() == 0) {
			return new ResponseEntity(Constantes.NORESULTS, HttpStatus.OK);
		}
		return new ResponseEntity<List<DeveloperDto>>(results, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "findDeveloperByIdLang", method = RequestMethod.GET)
	public ResponseEntity<List<DeveloperDto>> findDeveloperByIdLangage(
			@RequestParam(name = "idLang") String idLangage) {
		List<DeveloperDto> results;
		try {
			results = developerSrv.findDevByIdLangage(idLangage);
		} catch (Exception e) {
			return new ResponseEntity(Constantes.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (results == null || results.size() == 0) {
			return new ResponseEntity(Constantes.NORESULTS, HttpStatus.OK);
		}
		return new ResponseEntity<List<DeveloperDto>>(results, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<DeveloperDto>> findAll() {
		List<DeveloperDto> results;
		try {
			results = developerSrv.findAll();
		} catch (Exception e) {
			return new ResponseEntity(Constantes.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (results == null || results.size() == 0) {
			return new ResponseEntity(Constantes.NORESULTS, HttpStatus.OK);
		}
		return new ResponseEntity<List<DeveloperDto>>(results, HttpStatus.OK);
	}

}

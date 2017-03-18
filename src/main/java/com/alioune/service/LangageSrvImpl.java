package com.alioune.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alioune.dao.LangageDao;
import com.alioune.entities.Langage;

@Service
public class LangageSrvImpl implements LangageSrv {

	@Autowired
	private LangageDao langageDao;

	@Override
	public List<Langage> add(List<Langage> langs) {
		List<Langage> results = new ArrayList<Langage>();
		for (Langage lang : langs) {
			langageDao.save(lang);
			results.add(lang);
		}
		return results;
	}

	@Override
	public List<Langage> getAll() {
		List<Langage> results = new ArrayList<Langage>();
		langageDao.findAll().forEach(results::add);
		return results;
	}

	@Override
	public Langage findById(String id) {
		return langageDao.findOne(id);
	}

	@Override
	public List<Langage> findByLibelle(String lib) {
		return langageDao.findByLibelleContainingIgnoreCase(lib);
	}

}

package com.alioune.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alioune.dao.DeveloperLangageDao;
import com.alioune.entities.DeveloperLangage;

@Service
public class DeveloperLangageSrvImpl implements DeveloperLangageSrv {

	@Autowired
	private DeveloperLangageDao developerLangageDao;

	@Override
	public DeveloperLangage associateDevToALangage(String idDev, String idLang) {
		DeveloperLangage developerLangage = new DeveloperLangage();
		developerLangage.setIdDev(idDev);
		developerLangage.setIdLang(idLang);
		return developerLangageDao.save(developerLangage);
	}

}

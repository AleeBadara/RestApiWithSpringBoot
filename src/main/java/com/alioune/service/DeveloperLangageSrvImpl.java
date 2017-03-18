package com.alioune.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alioune.dal.DeveloperLangageRepository;
import com.alioune.entities.DeveloperLangage;

@Service
public class DeveloperLangageSrvImpl implements DeveloperLangageSrv {

	@Autowired
	private DeveloperLangageRepository developerLangageDao;

	@Override
	public DeveloperLangage associateDevToALangage(String idDev, String idLang) {
		DeveloperLangage developerLangage = new DeveloperLangage();
		developerLangage.setIdDev(idDev);
		developerLangage.setIdLang(idLang);
		return developerLangageDao.save(developerLangage);
	}

}

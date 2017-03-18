package com.alioune.service;

import com.alioune.entities.DeveloperLangage;

public interface DeveloperLangageSrv {
	DeveloperLangage associateDevToALangage(String idDev, String idLang);
}

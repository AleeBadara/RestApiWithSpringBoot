package com.alioune.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alioune.dao.DeveloperDao;
import com.alioune.dao.DeveloperLangageDao;
import com.alioune.dao.LangageDao;
import com.alioune.entities.Developer;
import com.alioune.entities.DeveloperLangage;
import com.alioune.entities.Langage;
import com.alioune.model.DeveloperDto;
import com.alioune.utils.DeveloperMapper;

@Service
public class DeveloperSrvImpl implements DeveloperSrv {

	@Autowired
	private DeveloperDao developerDao;
	@Autowired
	private LangageDao langageDao;
	@Autowired
	private DeveloperLangageDao developerLangageDao;

	@Override
	public List<Developer> addDeveloper(List<Developer> devs) {
		List<Developer> results = new ArrayList<Developer>();
		for (Developer dev : devs) {
			results.add(developerDao.save(dev));
		}
		return results;
	}

	@Override
	public Developer updateDeveloper(Developer devToUpdate) {
		return developerDao.save(devToUpdate);
	}

	@Override
	public List<DeveloperDto> findDevByLibelleLangage(String libLangage) {
		List<DeveloperDto> results = new ArrayList<DeveloperDto>();
		List<Langage> langs = langageDao.findByLibelleContainingIgnoreCase(libLangage);
		for (Langage lang : langs) {
			List<DeveloperLangage> devsLangs = developerLangageDao.findByIdLang(lang.getId());
			for (DeveloperLangage devLang : devsLangs) {
				Developer dev = developerDao.findOne(devLang.getIdDev());
				DeveloperDto devDto = DeveloperMapper.transformEntityToDto(dev);
				devDto.getLangs().add(lang);
				results.add(devDto);
			}
		}
		return results;
	}

	@Override
	public List<DeveloperDto> findDevByIdLangage(String idLangage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeveloperDto> findAll() {
		List<DeveloperDto> results = new ArrayList<DeveloperDto>();
		List<Developer> devs = new ArrayList<Developer>();
		developerDao.findAll().forEach(devs::add);
		for (Developer dev : devs) {
			DeveloperDto dto = DeveloperMapper.transformEntityToDto(dev);
			List<DeveloperLangage> devLangs = developerLangageDao.findByIdDev(dev.getId());
			for (DeveloperLangage devLang : devLangs) {
				Langage lang = langageDao.findOne(devLang.getIdLang());
				dto.getLangs().add(lang);
			}
			results.add(dto);
		}
		return results;
	}
}

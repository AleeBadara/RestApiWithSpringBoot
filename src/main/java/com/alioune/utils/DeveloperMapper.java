package com.alioune.utils;

import com.alioune.entities.Developer;
import com.alioune.model.DeveloperDto;

public class DeveloperMapper {

	public static DeveloperDto transformEntityToDto(Developer entity) {
		DeveloperDto dto = new DeveloperDto();
		dto.setAdresse(entity.getAdresse());
		dto.setId(entity.getId());
		dto.setNom(entity.getNom());
		dto.setPrenom(entity.getPrenom());
		return dto;
	}

}

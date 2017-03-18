package com.alioune.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alioune.entities.Developer;

@Repository
public interface DeveloperDao extends CrudRepository<Developer, String> {

}

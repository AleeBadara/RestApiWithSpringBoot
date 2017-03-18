package com.alioune.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alioune.entities.Developer;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, String> {

}

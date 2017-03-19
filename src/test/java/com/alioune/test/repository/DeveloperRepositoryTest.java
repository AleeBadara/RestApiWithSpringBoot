package com.alioune.test.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alioune.dal.DeveloperRepository;
import com.alioune.entities.Developer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeveloperRepositoryTest {

	Developer dev;
	String idDev;

	@Before
	public void setUp() {
		dev = new Developer();
		idDev = UUID.randomUUID().toString();
		dev.setId(idDev);
		dev.setAdresse("Ground Zero");
		dev.setNom("Doe");
		dev.setPrenom("John");
		developerDao.save(dev);
	}

	@Autowired
	private DeveloperRepository developerDao;

	@Test
	public void testAddDeveloper() {
		List<Developer> devs = new ArrayList<Developer>();
		developerDao.findAll().forEach(devs::add);
		;
		assertEquals("John", devs.get(0).getPrenom());
	}

	@Test
	public void testUpdateDeveloper() {
		dev.setPrenom("Jane");
		developerDao.save(dev);
		Developer result = developerDao.findOne(idDev);
		assertEquals("Jane", result.getPrenom());
	}

}

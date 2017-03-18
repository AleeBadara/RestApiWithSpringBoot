package com.alioune.test.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

	@Autowired
	private DeveloperRepository developerDao;

	@Test
	public void testAddDeveloper() {
		Developer dev = new Developer();
		dev.setId(UUID.randomUUID().toString());
		dev.setNom("Test");
		dev.setPrenom("Test");
		developerDao.save(dev);
		List<Developer> devs = new ArrayList<Developer>();
		developerDao.findAll().forEach(devs::add);
		;
		assertEquals("Test", devs.get(0).getNom());
	}

}

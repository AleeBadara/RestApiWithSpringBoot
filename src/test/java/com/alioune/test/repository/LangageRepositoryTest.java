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

import com.alioune.dal.LangageRepository;
import com.alioune.entities.Langage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LangageRepositoryTest {
	Langage lang;
	String idLang;
	@Autowired
	private LangageRepository langageDao;

	@Before
	public void setUp() {
		lang = new Langage();
		idLang = UUID.randomUUID().toString();
		lang.setId(idLang);
		lang.setLibelle("Java");
		langageDao.save(lang);
	}

	@Test
	public void testAddLangage() {
		List<Langage> langs = new ArrayList<Langage>();
		langageDao.findAll().forEach(langs::add);
		;
		assertEquals("Java", langs.get(0).getLibelle());
	}

	@Test
	public void testFindById() {
		Langage res = langageDao.findOne(idLang);
		assertEquals("Java", res.getLibelle());
	}

	@Test
	public void findByLibelle() {
		langageDao.deleteAll();
		langageDao.save(lang);
		List<Langage> res = langageDao.findByLibelleContainingIgnoreCase("Java");
		assertEquals(1, res.size());
	}

}

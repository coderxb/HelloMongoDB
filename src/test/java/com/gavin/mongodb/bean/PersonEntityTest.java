package com.gavin.mongodb.bean;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.Test;

import com.gavin.mongodb.dao.PersonEntityDao;
import com.github.jmkgreen.morphia.Morphia;
import com.github.jmkgreen.morphia.query.Query;
import com.github.jmkgreen.morphia.query.QueryResults;
import com.mongodb.Mongo;

public class PersonEntityTest {

	@Test
	public void testPersonCreate() {
		try {
			Mongo mg = new Mongo();
			Morphia ma = new Morphia();
			PersonEntityDao personDao = new PersonEntityDao(mg, ma, "test");
			for (int i = 0; i < 10; i++) {
				PersonEntity person = new PersonEntity();
				person.setName("Person" + i);
				personDao.save(person);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testQueryPersonByFind() {
		try {
			Mongo mg = new Mongo();
			Morphia ma = new Morphia();
			PersonEntityDao personDao = new PersonEntityDao(mg, ma, "test");
			QueryResults<PersonEntity> ret = personDao.find();
			for (PersonEntity ebo : ret) {
				System.out.println(ebo.getId() + " - " + ebo.getName());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryPersonByCreateQuery() {
		try {
			Mongo mg = new Mongo();
			Morphia ma = new Morphia();
			PersonEntityDao personDao = new PersonEntityDao(mg, ma, "test");
			Query<PersonEntity> query = personDao.createQuery();
			List<PersonEntity> pList = query.field("name").equal("Person11")
					.asList();
			for (PersonEntity ebo : pList) {
				System.out.println(ebo.getId() + " - " + ebo.getName());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

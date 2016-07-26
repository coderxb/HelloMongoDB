package com.gavin.mongodb.dao;

import org.bson.types.ObjectId;

import com.gavin.mongodb.bean.PersonEntity;
import com.github.jmkgreen.morphia.Morphia;
import com.github.jmkgreen.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public class PersonEntityDao extends BasicDAO<PersonEntity, ObjectId> {

	public PersonEntityDao(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}

	// public PersonEntityDao(Class<PersonEntity> personEbo, Mongo mongo,
	// Morphia morphia, String dbName) {
	// super(personEbo, mongo, morphia, dbName);
	//
	// dt = morphia.createDatastore(mongo, dbName);
	// }

}

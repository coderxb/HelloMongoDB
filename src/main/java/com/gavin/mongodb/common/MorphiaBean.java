package com.gavin.mongodb.common;

import com.github.jmkgreen.morphia.Datastore;
import com.github.jmkgreen.morphia.Morphia;
import com.mongodb.Mongo;

public class MorphiaBean extends Morphia {
	private Mongo mg;
	private String dbName;

	public Datastore getDatastore() {
		if (this.mg == null || this.dbName == null) {
			return null;
		}
		return createDatastore(mg, dbName);
	}

	public Mongo getMg() {
		return mg;
	}

	public void setMg(Mongo mg) {
		this.mg = mg;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

}

package com.gavin.mongodb;

import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * MongoDB 简单的CRUD操作
 */
public class SimpleCRUD {
	private DBCollection collections;

	public DB initDb(String dbName) throws Exception {
		DB db = null;
		try {
			Mongo mg = new Mongo();
			// mg = new Mongo("localhost", 27017);
			db = mg.getDB(dbName);
			if (db == null) {
				throw new Exception("find dataDB is not exist!!!");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return db;
	}

}

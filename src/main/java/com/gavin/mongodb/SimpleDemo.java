package com.gavin.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class SimpleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Mongo mg = new Mongo();
			/**
			 * get all databases
			 */
			System.out.println("----------get all databases---------");
			for (String dbName : mg.getDatabaseNames()) {
				System.out.print(dbName + " ");
			}
			System.out.println("");

			DB db = mg.getDB("test");
			/**
			 * search all collections
			 */
			System.out.println("------get all collections---------");
			for (String name : db.getCollectionNames()) {
				System.out.println("collectionName: " + name);
			}

			DBCollection blog = db.getCollection("blog");
			/**
			 * search all data of collection
			 */
			DBCursor cur = blog.find();
			System.out
					.println("------get search collections information---------");
			while (cur.hasNext()) {
				DBObject dbObject = (DBObject) cur.next();
				System.out.println(dbObject);
			}
			System.out.println(cur.count());
			System.out.println(cur.getCursorId());
			System.out.println(JSON.serialize(cur));

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

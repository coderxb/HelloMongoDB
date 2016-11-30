/**
 * MongoDBSingleTest.java   2016年11月16日 下午3:21:41 by xuebing 
 *
 * Copyright (c) 2010 - 2016 All rights reserved.
 * 
 */
package com.gavin.mongodb.check;

import java.util.Collection;
import org.bson.Document;
import org.junit.Test;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoDBSingleTest {

    @Test
    public void test() {
        //        List<MongoCredential> mcList = new ArrayList<MongoCredential>();
        //        MongoCredential mc = MongoCredential.createCredential("testroot", "admin", "123456".toCharArray());
        //        mcList.add(mc);
        //
        //        InetSocketAddress isa = new InetSocketAddress("192.168.18.221", 27017);
        //        ServerAddress addr = new ServerAddress(isa);
        //        MongoClient client = new MongoClient(addr, mcList);

        MongoClient client = new MongoClient("localhost", 27017);

        MongoIterable<String> listDatabaseNames = client.listDatabaseNames();
        for (String dbName : listDatabaseNames) {
            System.out.println("Database name = " + dbName);
        }
        Collection<DB> usedDatabases = client.getUsedDatabases();
        for (DB db : usedDatabases) {
            System.out.println("Current User Database Name = " + db.getName());
        }

        MongoDatabase database = client.getDatabase("test");
        String collectionName = "lxbofdb";
        database.createCollection(collectionName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document document = new Document("name", "Welcome");
        collection.insertOne(document);

        client.close();
    }

}

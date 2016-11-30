/**
 * MongoDBTest.java   2016年11月16日 下午2:43:13 by xuebing 
 *
 * Copyright (c) 2010 - 2016 All rights reserved.
 * 
 */
package com.gavin.mongodb.check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.junit.Test;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBMutilTest {

    @Test
    public void test() {
        List<MongoCredential> mcList = new ArrayList<MongoCredential>();
        MongoCredential mc = MongoCredential.createCredential("testroot", "admin", "123456".toCharArray());
        mcList.add(mc);

        MongoClient client = new MongoClient(Arrays.asList(new ServerAddress("192.168.18.221", 27017),
            new ServerAddress("192.168.18.222", 27017), new ServerAddress("192.168.18.224", 27017)), mcList);

        // or use a connection string
        //        MongoClientURI connectionString = new MongoClientURI(
        //            "mongodb://localhost:27017,localhost:27018,localhost:27019");
        //        MongoClient mongoClient = new MongoClient(connectionString);

        // for single
        //        InetSocketAddress isa = new InetSocketAddress("192.168.18.221", 27017);
        //        ServerAddress addr = new ServerAddress(isa);
        //        MongoClient client = new MongoClient(addr, mcList);

        MongoDatabase db = client.getDatabase("xb-test-db-0");
        String collectionName = "collecion-4232";
        db.createCollection(collectionName);
        MongoCollection<Document> collection = db.getCollection(collectionName);
        Document document = new Document("name", "Welcome");
        collection.insertOne(document);
        client.close();
    }

}

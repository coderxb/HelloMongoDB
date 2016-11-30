/**
 * BigCreateCollectionTest.java   2016年11月22日 下午3:10:27 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package com.gavin.mongodb.check;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class BigCreateCollectionTest {

    private static MongoClient client = null;

    @Before
    public void setUp() throws Exception {
        List<MongoCredential> mcList = new ArrayList<MongoCredential>();
        MongoCredential mc = MongoCredential.createCredential("testroot", "admin", "123456".toCharArray());
        mcList.add(mc);

        InetSocketAddress isa = new InetSocketAddress("192.168.18.222", 27017);
        ServerAddress addr = new ServerAddress(isa);
        client = new MongoClient(addr, mcList);
        Thread.sleep(100);
    }

    @Test
    @Ignore
    public void test() {

        MongoDatabase db = client.getDatabase("xb-test-db-1");

        for (int i = 1; i < 1000; i++) {

            String collectionName = "collecion" + i;
            db.createCollection(collectionName);
            MongoCollection<Document> collection = db.getCollection(collectionName);
            Document document = new Document("name", "Welcome" + i);
            collection.insertOne(document);
        }

        client.close();
    }

    @Test
    public void testBlog() {
        MongoDatabase db = client.getDatabase("blogdb");

        //Create Blog
        String blogCollectionName = "blog";
        MongoCollection<Document> blogCollection = db.getCollection(blogCollectionName);
        if (blogCollection != null) {
            db.createCollection(blogCollectionName);
        }
        String content = "From what I can make out, Proxool is a connection pool for JDBC connections. This suggests to me that the problem is that your application is is misusing the connection pool. Instead of calling close on the statement objects, your code is probably dropping them and/or their parent connections. The Proxool is relying on finalizers to close the underlying driver-implemented objects ... but this requires those Finalizer instances. It could also mean that you are causing the connection to open / close (real) database connections more frequently than is necessary, and that would be bad for performance.";
        for (int i = 1; i < 100000; i++) {
            BasicDBObject blog = new BasicDBObject();
            blog.put("name", "article" + i);
            blog.put("content", content);
            blog.put("create_time", new Date());
            Document document = new Document(blog);
            blogCollection.insertOne(document);
        }
        
        //Create user
        String userCollectionName = "user";
        MongoCollection<Document> userCollection = db.getCollection(userCollectionName);
        if (userCollection != null) {
            db.createCollection(userCollectionName);
        }
        for (int i = 1; i < 10000; i++) {
            BasicDBObject user = new BasicDBObject();
            user.put("name", "user" + i);
            user.put("age", Math.random() * 100);
            if (i / 2 == 0) {
                user.put("sex", "男");
            } else {
                user.put("sex", "女");
            }
            Document document = new Document(user);
            userCollection.insertOne(document);
        }
    }

}

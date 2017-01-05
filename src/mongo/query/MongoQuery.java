/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.query;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mongo.connect.MongoConnector;
import org.bson.Document;

/**
 *
 * @author Le Tam
 */
public class MongoQuery {

//    private static MongoConnector connector;
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    public void getListCourses() {
        MongoConnector connector = new MongoConnector();
        connector.ConnectMongoDB("localhost", 27017);
        connector.getDB("education");
        collection = connector.getColl("course");
        System.out.println(collection.count());
        
    }

}

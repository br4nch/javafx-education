/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.connect;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import java.lang.reflect.Type;
import java.net.ConnectException;

/**
 *
 * @author Le Tam
 */
public class MongoConnector {

    //VARIABLES-----------------------------------------------------------------
    private static MongoConnector connector;
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    //CONSTRUCTOR---------------------------------------------------------------
    public MongoConnector() {
    }

    public static MongoConnector getInstance() {
        if (connector == null) {
            connector = new MongoConnector();
        }
        return connector;
    }

    //FUNCTION------------------------------------------------------------------
    public void ConnectMongoDB(String serverName, int port) {
        if (mongoClient == null) {
            mongoClient = new MongoClient(serverName, port);
        }
    }

    public void getDB(String dbName) {
        database = mongoClient.getDatabase(dbName);
    }

    public void getColl(String collName) {
        collection = database.getCollection(collName);
    }

    public void InsertDocument(Document doc) {
        collection.insertOne(doc);
    }

    public void DeleteDocument(Document doc) {
        collection.deleteOne(doc);

    }

    public void UpdateDocument(Document doc, Document doc1) {
        collection.updateOne(doc, doc1);
    }

}

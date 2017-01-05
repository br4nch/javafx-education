/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import java.lang.reflect.Type;
import model.User;
import org.bson.Document;
import mongo.connect.MongoConnector;

/**
 *
 * @author Le Tam
 */
public class Main {

    public static void main(String[] args) {
        MongoConnector mongoConnector = new MongoConnector();
        mongoConnector.ConnectMongoDB("localhost", -5);
        mongoConnector.getDB("test");
        mongoConnector.getColl("huhu");
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1);
        mongoConnector.InsertDocument(doc);
//        Document myDoc = collection.find().first();
//        Document abc = new Document();
//        abc.putAll(doc);
//        String json = JSON.serialize(abc);
//        BasicDBObject bson = (BasicDBObject) JSON.parse(json);
//        System.out.println(doc);
//        System.out.println(json);
//        System.out.println(bson);
//        Gson gson = new Gson();
//        User u = new User();
//        Type type = new TypeToken<User>() {
//        }.getType();
//        u = gson.fromJson(myDoc.toJson(), type);
//        String a = u.getName();
//        System.out.println(a);
    }
}

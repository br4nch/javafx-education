/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import java.lang.reflect.Type;
import model.User;
import mongo.connect.MongoConnector;
import mongo.query.MongoQuery;
import org.bson.Document;

/**
 *
 * @author Le Tam
 */
public class MainTest {

    public static void main(String[] args) {

//        MongoClient client = new MongoClient("localhost", 27017);
//        MongoDatabase database = client.getDatabase("education");
//        MongoCollection<Document> collection = database.getCollection("course");
//        System.out.println(collection.count());

        MongoConnector connector = new MongoConnector();
        connector.ConnectMongoDB("localhost", 27017);
        connector.getDB("education");
//        connector.getColl("course");
        System.out.println(connector.doCountListCourses("course"));
//        Document doc = new Document("name", "MongoDB")
//                .append("type", "database")
//                .append("count", 1);
//        mongoConnector.InsertDocument(doc);
//        Document myDoc = collection.find().first();
//        BasicDBObject bson = (BasicDBObject) JSON.parse(doc.toJson());
//        System.out.println(doc);
//        System.out.println(bson);
//        Gson gson = new Gson();
//        User u = new User();
//        Type type = new TypeToken<User>() {
//        }.getType();
//        u = gson.fromJson(doc.toJson(), type);
//        String a = u.getName();
//        String b = u.getType();
//        String c = u.getCount();
//        System.out.println(a + " " + b + " " + c);
    }
}

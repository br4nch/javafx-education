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
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.User;
import mongo.connect.MongoConnector;
import mongo.ulti.ConvertUtil;
import org.bson.Document;

/**
 *
 * @author Le Tam
 */
public class MainTest {

    public static void main(String[] args) {
        ConvertUtil convertUtil = new ConvertUtil();
        Course c = new Course();
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("education");
        MongoCollection<Document> collection = database.getCollection("course");
        Document doc = new Document();
        MongoCursor<Document> cursor = collection.find().iterator();
        List<Course> list = new ArrayList<Course>();
        Gson gson = new Gson();
        Type type = new TypeToken<List<Course>>() {
        }.getType();
        doc = new Document("username:", "Andreanne_Bradtke67")
                .append("passowrd", "5dn0NwO5JxIQSB7");
        System.out.println(collection.find(doc).first());
        
//        List<Document> tests = (List<Document>) collection.find().into(
//                new ArrayList<Document>());
//        list = gson.fromJson(gson.toJson(tests), type);
//        System.out.println(list);
//        for (Course course : list) {
//            System.out.println("Name: " + course.getName());
//            System.out.println("Author: " + course.getAuthor());
//            System.out.println("Content: " + course.getContent());
//            System.out.println("Price: " + course.getPrice());
//            System.out.println("Type: " + course.getType());
//        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educationframe;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dialog.FxDialog;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.Course;
import model.User;
import org.bson.Document;

/**
 *
 * @author Le Tam
 */
public class EducationDocumentController implements Initializable {

    //FXML----------------------------------------------------------------------

    //VARIABLES-----------------------------------------------------------------
    Course course = new Course();
    User user = new User();
    List<Course> listCourse = new ArrayList<Course>();
    FxDialog dialog = new FxDialog();
    MongoClient client = new MongoClient("localhost", 27017);
    MongoDatabase database = client.getDatabase("education");
    MongoCollection<Document> collection;
    Document doc;
    private Gson gson = new Gson();
    private Type type;

    //FUNCTIONS-----------------------------------------------------------------
    public List getListCourse() {
        collection = database.getCollection("course");
        List<Document> listDoc = (List<Document>) collection.find().into(new ArrayList<Document>());
        if (listCourse != null) {
            type = new TypeToken<Course>() {
            }.getType();
            listCourse = gson.fromJson(gson.toJson(listDoc), type);
        }
        return listCourse;
    }

    public User getUser(String username) {
        collection = database.getCollection("user");
        doc = new Document("username", username);
        Document userDoc = collection.find(doc).first();
        System.out.println(userDoc.toJson());
        if (null != userDoc) {
            type = new TypeToken<User>() {
            }.getType();  
            user = gson.fromJson(userDoc.toJson(), type);
            System.out.println(user.getUsername() + " " + user.getPassword());
        }
        return user;
    }


    public void InsertDocument() {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


}

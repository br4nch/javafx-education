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
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Course;
import model.User;
import org.bson.Document;

/**
 *
 * @author Le Tam
 */
public class EducationDocumentController implements Initializable {

    Course course = new Course();
    User user = new User();
    List<Course> listCourse = new ArrayList<Course>();
    private final static MongoClient client = new MongoClient("localhost", 27017);
    private final static MongoDatabase database = client.getDatabase("education");
    private static MongoCollection<Document> collection;
    private static Document doc;
    private Gson gson = new Gson();
    private Type type;

    public List getListCourse() {
        collection = database.getCollection("Course");
        List<Document> listDoc = (List<Document>) collection.find().into(new ArrayList<Document>());
        if (listCourse == null) {
            type = new TypeToken<Course>() {
            }.getType();
            listCourse = gson.fromJson(gson.toJson(listDoc), type);
        }
        return listCourse;
    }
    public void checkValidLogin(String username, String password){
        collection = database.getCollection("User");
        doc = new Document("username:", username)
                .append("passowrd", password);
        collection.find(doc).first();
    }
    public void InsertDocument(){
        
    }
    @FXML
    private ImageView imgLogin;

    @FXML
    private JFXTextField tfUsername;

    @FXML
    private JFXPasswordField tfPassword;

    @FXML
    void doLogin(ActionEvent event) {
        String password = tfPassword.getText();
        String username = tfUsername.getText();
    }

    @FXML
    void goToRegister(ActionEvent event) {

    }

    @FXML
    public void btnClick(ActionEvent event) {
        FxDialog dialog = new FxDialog();
        dialog.showInformation("Hi", "Good Morning y'all!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

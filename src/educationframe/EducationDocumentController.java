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

    //FXML----------------------------------------------------------------------
    @FXML
    private ImageView imgLogin;

    @FXML
    private JFXTextField tfUsername;

    @FXML
    private JFXPasswordField tfPassword;

    //VARIABLES-----------------------------------------------------------------
    Course course = new Course();
    User user = new User();
    List<Course> listCourse = new ArrayList<Course>();
    FxDialog dialog = new FxDialog();
    private final static MongoClient client = new MongoClient("localhost", 27017);
    private final static MongoDatabase database = client.getDatabase("education");
    private static MongoCollection<Document> collection;
    private static Document doc;
    private Gson gson = new Gson();
    private Type type;

    //FUNCTIONS-----------------------------------------------------------------
    public List getListCourse() {
        collection = database.getCollection("Course");
        List<Document> listDoc = (List<Document>) collection.find().into(new ArrayList<Document>());
        if (listCourse != null) {
            type = new TypeToken<Course>() {
            }.getType();
            listCourse = gson.fromJson(gson.toJson(listDoc), type);
        }
        return listCourse;
    }

    public User getUser(String username) {
        collection = database.getCollection("User");
        doc = new Document("username:", username);
        Document userDoc = collection.find(doc).first();
        if (userDoc != null) {
            type = new TypeToken<User>() {
            }.getType();
            user = gson.fromJson(userDoc.toJson(), type);
            System.out.println(user.getUsername() + " " + user.getPassword());
        }
        else{
            FxDialog.showError("Lỗi", "Đăng nhập thất bại");
        }
        return user;
    }

    public void checkLogin(String username, String password) {
        user = getUser(username);
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            FxDialog.showInformation("Đăng nhập thành công", "Chào mừng đến với phần mềm quản lý dạy học");
        } else {
            FxDialog.showError("Đăng nhập thất bại", "Kiểm tra lại username hoặc password");
        }
    }

    public void InsertDocument() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void doLogin(ActionEvent event) {
        String password = tfPassword.getText();
        String username = tfUsername.getText();
        checkLogin(username, password);
    }

    @FXML
    void goToRegister(ActionEvent event) {

    }

}

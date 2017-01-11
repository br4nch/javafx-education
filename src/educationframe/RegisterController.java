/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educationframe;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Course;
import model.User;
import org.bson.Document;

/**
 * FXML Controller class
 *
 * @author Le Tam
 */
public class RegisterController implements Initializable {

    //FXML----------------------------------------------------------------------
    @FXML
    private JFXTextField tfUsername;
    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXDatePicker tfDOB;
    @FXML
    private JFXPasswordField tfPassword;
    @FXML
    private JFXPasswordField tfConfirm;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //FUNCTIONS-----------------------------------------------------------------
   
    public void InsertUser(String username,String password, String email, String dob){
        collection = database.getCollection("user");
        doc = new Document("username", username)
                .append("passowrd", password)
                .append("email", email)
                .append("dob", dob);
        collection.insertOne(doc);
    }
   
    @FXML
    private void doRegister(ActionEvent event) {
        String username = tfUsername.getText().toLowerCase();
        String password = tfPassword.getText().toLowerCase();
        String email = tfEmail.getText().toLowerCase();
        String dob = tfDOB.getValue().toString().toLowerCase();
        String confirm = tfConfirm.getText().toLowerCase();
        if(username.isEmpty() || password.isEmpty() || email.isEmpty() || dob.isEmpty() || confirm.isEmpty()){
            FxDialog.showError("Thông tin bạn nhập còn thiếu", "Mời bạn điền đầy đủ thông tin");
        }
        else if(!password.matches(confirm) || !confirm.matches(password)){
            FxDialog.showError("Lỗi mật khẩu", "Xác thực mật khảu không trùng nhau");
        }
        else{
            InsertUser(username, password, email, dob);
        }
    }

    @FXML
    private void goToLogin(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene loginScene = new Scene(login);
        FadeTransition ft = new FadeTransition(Duration.millis(1500), login);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setTitle("Login");
        appStage.setScene(loginScene);
        appStage.show();        
                
    }

}

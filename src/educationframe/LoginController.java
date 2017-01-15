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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.Course;
import model.User;
import org.bson.Document;

/**
 * FXML Controller class
 *
 * @author Le Tam
 */
public class LoginController implements Initializable {

    @FXML
    private ImageView imgLogin;

    @FXML
    private JFXTextField tfUsername;

    @FXML
    private JFXPasswordField tfPassword;

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

    public User getUser(String username) {
        collection = database.getCollection("user");
        doc = new Document("username", username);
        Document userDoc = collection.find(doc).first();
        type = new TypeToken<User>() {
        }.getType();
        if (null != userDoc) {
            user = gson.fromJson(userDoc.toJson(), type);
        }
        return user;
    }

    public void checkLogin(String username, String password) {
        user = getUser(username);
        if (!username.equals(user.getUsername()) && !password.equals(user.getPassword())) {
            FxDialog.showError("Đăng nhập thất bại", "Kiểm tra lại username hoặc password");
        } else {
            FxDialog.showInformation("Đăng nhập thành công", "Chào mừng đến với phần mềm quản lý dạy học");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void goToMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent main = (Parent) loader.load();
        EducationDocumentController controller = loader.<EducationDocumentController>getController();
        controller.setUsernameProfile(tfUsername.getText().toLowerCase());
        Scene mainScene = new Scene(main);
        FadeTransition ft = new FadeTransition(Duration.millis(1500), main);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setTitle("Course");
        appStage.setScene(mainScene);
        appStage.show();
    }

    @FXML
    private void doLogin(ActionEvent event) throws IOException {
        String username = tfUsername.getText().toLowerCase();
        String password = tfPassword.getText().toLowerCase();
        if (!username.isEmpty() && !password.isEmpty()) {
            checkLogin(username.trim(), password.trim());
            goToMain(event);
        } else {
            FxDialog.showError("Lỗi", "Bạn chưa nhập thông tin");
        }
    }

    @FXML
    private void goToRegister(ActionEvent event) throws IOException {
        Parent register = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene registerScene = new Scene(register);
        FadeTransition ft = new FadeTransition(Duration.millis(1500), register);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setTitle("Register");
        appStage.setScene(registerScene);
        appStage.show();
    }

}

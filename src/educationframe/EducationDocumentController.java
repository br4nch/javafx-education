/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educationframe;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 *
 * @author Le Tam
 */
public class EducationDocumentController implements Initializable {

    //FXML----------------------------------------------------------------------
    @FXML
    private TextField tfFindCourse;

    @FXML
    private Button btnFindCourse;

    @FXML
    private TableView<?> tvCourse;

    @FXML
    private TableColumn<?, ?> colCourseName;

    @FXML
    private TableColumn<?, ?> colCourseType;

    @FXML
    private TableColumn<?, ?> colCoursePrice;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblCoursePrice;

    @FXML
    private Label lblCourseAuthor;

    @FXML
    private Label lblCourseContent;

    @FXML
    private Label lblCourseDuration;

    @FXML
    private Label lblCourseType;

    @FXML
    private Button btnAddToCart;

    @FXML
    private TextField tfFindCourseAdmin;

    @FXML
    private Button btnFindCourseAdmin;

    @FXML
    private TableView<?> tvCourseAdmin;

    @FXML
    private TableColumn<?, ?> colCourseNameAdmin;

    @FXML
    private TableColumn<?, ?> colCourseTypeAdmin;

    @FXML
    private TableColumn<?, ?> colCoursePriceAdmin;

    @FXML
    private TextField tfCourseNameAdmin;

    @FXML
    private TextField tfCoursePriceAdmin;

    @FXML
    private TextField tfCourseAuthorAdmin;

    @FXML
    private TextField tfCourseContentAdmin;

    @FXML
    private TextField tfCourseDurationAdmin;

    @FXML
    private TextField tfCourseTypeAdmin;

    @FXML
    private Button btnInsertCourse;

    @FXML
    private Button btnDeleteCourse;

    @FXML
    private Button btnEditCourse;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnAccept;

    @FXML
    private Button btnCancel;

    @FXML
    private Label lblCourseNameCart;

    @FXML
    private Label lblCoursePriceCart;

    @FXML
    private Label lblCourseAuthorCart;

    @FXML
    private Label lblCourseContentCart;

    @FXML
    private Label lblCourseDurationCart;

    @FXML
    private Label lblCourseTypeCart;

    @FXML
    private TableView<?> tvCourseCart;

    @FXML
    private TableColumn<?, ?> colCourseNameCart;

    @FXML
    private TableColumn<?, ?> colCourseTypeCart;

    @FXML
    private TableColumn<?, ?> colCoursePriceCart;

    @FXML
    private MenuItem miPopOver;

    @FXML
    private Circle circleImageUser;

    @FXML
    private Label lblUserNamePopOver;

    @FXML
    private Label lblDOB;

    @FXML
    private Label lblEmail;

    @FXML
    private Button btnLogout;

    @FXML
    private ImageView ivUser;

    @FXML
    private Label lblUsername;
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
            for (Course course1 : listCourse) {
                System.out.println(course1.getName() + " " + course1.getType());

            }
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

    @FXML
    void doAccept(ActionEvent event) {

    }

    @FXML
    void doAddItem(ActionEvent event) {
        getListCourse();
    }

    @FXML
    void doCancel(ActionEvent event) {

    }

    @FXML
    void doDeleteCourse(ActionEvent event) {

    }

    @FXML
    void doEditCourse(ActionEvent event) {

    }

    @FXML
    void doFindCourse(ActionEvent event) {

    }

    @FXML
    void doFindCourseAdmin(ActionEvent event) {

    }

    @FXML
    void doInsertCourse(ActionEvent event) {

    }

    @FXML
    void doLogout(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

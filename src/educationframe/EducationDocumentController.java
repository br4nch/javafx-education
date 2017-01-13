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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 *
 * @author Le Tam
 */
public class EducationDocumentController implements Initializable {

    private String usernameProfile;

    private boolean check;

    //FXML----------------------------------------------------------------------
    @FXML
    private TextField tfFindCourse;

    @FXML
    private Button btnFindCourse;

    @FXML
    private TableView<Course> tvCourse;

    @FXML
    private TableColumn<Course, String> colCourseName;

    @FXML
    private TableColumn<Course, String> colCourseType;

    @FXML
    private TableColumn<Course, String> colCoursePrice;

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
    private TableView<Course> tvCourseAdmin;

    @FXML
    private TableColumn<Course, String> colCourseNameAdmin;

    @FXML
    private TableColumn<Course, String> colCourseTypeAdmin;

    @FXML
    private TableColumn<Course, String> colCoursePriceAdmin;

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
    private Button btnSave;

    @FXML
    private Button btnNotSave;

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
    private TableView<Course> tvCourseCart;

    @FXML
    private TableColumn<Course, String> colCourseNameCart;

    @FXML
    private TableColumn<Course, String> colCourseTypeCart;

    @FXML
    private TableColumn<Course, String> colCoursePriceCart;

    @FXML
    private MenuItem miPopOver;

    @FXML
    private Circle circleImageUser;

    @FXML
    private Label lblFullName;

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

    @FXML
    private MenuButton menuBtn;
    //VARIABLES-----------------------------------------------------------------
    Course course = new Course();

    User user = new User();

    List<Course> listCourse = new ArrayList<Course>();

    MongoClient client = new MongoClient("localhost", 27017);

    MongoDatabase database = client.getDatabase("education");

    MongoCollection<Document> collection;

    Document doc;

    private Gson gson = new Gson();

    private Type type;

    //GETTER-SETTER-------------------------------------------------------------
    public void setUsernameProfile(String user) {
        this.usernameProfile = user;
    }

    //FUNCTIONS-----------------------------------------------------------------
    public List getListCourse() {
        collection = database.getCollection("course");
        List<Document> listDoc = (List<Document>) collection.find().into(new ArrayList<Document>());
        if (null != listCourse) {
            type = new TypeToken<List<Course>>() {
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

    public void ShowData() {
        listCourse = getListCourse();
        ObservableList<Course> obsList = FXCollections.observableArrayList(listCourse);
        colCourseName.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        colCourseType.setCellValueFactory(new PropertyValueFactory<Course, String>("type"));
        colCoursePrice.setCellValueFactory(new PropertyValueFactory<Course, String>("price"));
        tvCourse.setItems(obsList);
        tvCourse.getColumns().clear();
        tvCourse.getColumns().addAll(colCourseName, colCourseType, colCoursePrice);
    }

    public void ShowDataAdmin() {
        listCourse = getListCourse();
        ObservableList<Course> obsList = FXCollections.observableArrayList(listCourse);
        colCourseNameAdmin.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        colCourseTypeAdmin.setCellValueFactory(new PropertyValueFactory<Course, String>("type"));
        colCoursePriceAdmin.setCellValueFactory(new PropertyValueFactory<Course, String>("price"));
        tvCourseAdmin.setItems(obsList);
        tvCourseAdmin.getColumns().clear();
        tvCourseAdmin.getColumns().addAll(colCourseNameAdmin, colCourseTypeAdmin, colCoursePriceAdmin);

    }

    public void InsertDocument() {

    }

    public void DeleteDocument() {

    }

    public void EditDocument() {
    }

    public void setTextField(boolean b) {
        tfCourseNameAdmin.setEditable(b);
        tfCourseContentAdmin.setEditable(b);
        tfCourseDurationAdmin.setEditable(b);
        tfCoursePriceAdmin.setEditable(b);
        tfCourseAuthorAdmin.setEditable(b);
        tfCourseTypeAdmin.setEditable(b);
    }

    public void setNull() {
        this.tfCourseAuthorAdmin.setText(null);
        this.tfCourseContentAdmin.setText(null);
        this.tfCourseDurationAdmin.setText(null);
        this.tfCourseNameAdmin.setText(null);
        this.tfCoursePriceAdmin.setText(null);
        this.tfCourseTypeAdmin.setText(null);
    }

    public void setButton(boolean b) {
        this.btnInsertCourse.setDisable(b);
        this.btnEditCourse.setDisable(b);
        this.btnDeleteCourse.setDisable(b);
        this.btnSave.setDisable(!b);
        this.btnNotSave.setDisable(!b);
    }

    @FXML
    void AddToCart(ActionEvent event) {
    }

    @FXML
    void doAccept(ActionEvent event) {

    }

    @FXML
    void doCancel(ActionEvent event) {

    }

    @FXML
    void doDeleteCourse(ActionEvent event) {
    }

    @FXML
    void doEditCourse(ActionEvent event) {
        setTextField(true);
        tfCourseNameAdmin.requestFocus();
        setButton(true);
        check = false;
    }

    @FXML
    void doFindCourse(ActionEvent event) {

    }

    @FXML
    void doFindCourseAdmin(ActionEvent event) {

    }

    @FXML
    void doInsertCourse(ActionEvent event) {
        setNull();
        setTextField(true);
        tfCourseNameAdmin.requestFocus();
        setButton(true);
        check = true;
    }

    @FXML
    void doNotSave(ActionEvent event) {
        setNull();
        setTextField(false);
        setButton(false);
    }

    @FXML
    void doSave(ActionEvent event) {

    }

    @FXML
    void doLogout(ActionEvent event) throws IOException {
        if (FxDialog.showConfirm("Thong bao", "Ban co muon thoat?") == "OK") {
            Parent register = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene registerScene = new Scene(register);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), register);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            Stage appStage = (Stage) menuBtn.getScene().getWindow();
//        .getSource()).getScene().getWindow();
            appStage.setTitle("Login");
            appStage.setScene(registerScene);
            appStage.show();
        } else {
            return;
        }
    }

    public void getRowValue() {
        tvCourse.setRowFactory(tv -> {
            TableRow<Course> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {

                    Course clickedRow = row.getItem();
                    lblCourseName.setText(clickedRow.getName());
                    lblCourseType.setText(clickedRow.getType());
                    lblCourseDuration.setText(String.valueOf(clickedRow.getDuration()));
                    lblCourseContent.setText(clickedRow.getContent());
                    lblCourseAuthor.setText(clickedRow.getAuthor());
                    lblCoursePrice.setText(clickedRow.getPrice());
                }
            });
            return row;
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowData();
        ShowDataAdmin();
        setTextField(false);
        setButton(false);
        lblUsername.setText("Hello " + this.usernameProfile);
        getRowValue();
    }

}

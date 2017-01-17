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
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import dialog.FxDialog;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javax.sound.midi.ControllerEventListener;
import org.bson.types.ObjectId;

/**
 *
 * @author Le Tam
 */
public class EducationDocumentController implements Initializable {

    private ObjectId id;

    private ObjectId idCart;

    private String usernameProfile;

    private boolean check;

    private String nameEdit;

    private String typeEdit;

    private String durationEdit;

    private String contentEdit;

    private String authorEdit;

    private String priceEdit;

    //FXML----------------------------------------------------------------------
    @FXML
    private TextField tfFindCourse;

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

    List<Course> arrayCourse = new ArrayList<Course>();

    MongoClient client = new MongoClient("localhost", 27017);

    MongoDatabase database = client.getDatabase("education");

    MongoCollection<Document> collection;

    Document doc;

    private Gson gson = new Gson();

    private Type type;

    //GETTER-SETTER-------------------------------------------------------------
    /**
     * @return the idCart
     */
    public ObjectId getIdCart() {
        return idCart;
    }

    /**
     * @param idCart the idCart to set
     */
    public void setIdCart(ObjectId idCart) {
        this.idCart = idCart;
    }

    /**
     * @return the nameEdit
     */
    public String getNameEdit() {
        return nameEdit;
    }

    /**
     * @param nameEdit the nameEdit to set
     */
    public void setNameEdit(String nameEdit) {
        this.nameEdit = nameEdit;
    }

    /**
     * @return the typeEdit
     */
    public String getTypeEdit() {
        return typeEdit;
    }

    /**
     * @param typeEdit the typeEdit to set
     */
    public void setTypeEdit(String typeEdit) {
        this.typeEdit = typeEdit;
    }

    /**
     * @return the durationEdit
     */
    public String getDurationEdit() {
        return durationEdit;
    }

    /**
     * @param durationEdit the durationEdit to set
     */
    public void setDurationEdit(String durationEdit) {
        this.durationEdit = durationEdit;
    }

    /**
     * @return the contentEdit
     */
    public String getContentEdit() {
        return contentEdit;
    }

    /**
     * @param contentEdit the contentEdit to set
     */
    public void setContentEdit(String contentEdit) {
        this.contentEdit = contentEdit;
    }

    /**
     * @return the authorEdit
     */
    public String getAuthorEdit() {
        return authorEdit;
    }

    /**
     * @param authorEdit the authorEdit to set
     */
    public void setAuthorEdit(String authorEdit) {
        this.authorEdit = authorEdit;
    }

    /**
     * @return the priceEdit
     */
    public String getPriceEdit() {
        return priceEdit;
    }

    /**
     * @param priceEdit the priceEdit to set
     */
    public void setPriceEdit(String priceEdit) {
        this.priceEdit = priceEdit;
    }

    /**
     * @return the deleteId
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param deleteId the deleteId to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

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
            if (user == null) {
                FxDialog.showError("Lỗi", "Username này không tồn tại");
                return null;
            } else {
                return user;
            }
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

    public void ShowDataCart() {
        arrayCourse.add(getCourse(getNameEdit()));
        ObservableList<Course> obsList = FXCollections.observableArrayList(arrayCourse);
        colCourseNameCart.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        colCourseTypeCart.setCellValueFactory(new PropertyValueFactory<Course, String>("type"));
        colCoursePriceCart.setCellValueFactory(new PropertyValueFactory<Course, String>("price"));
        tvCourseCart.setItems(obsList);
        tvCourseCart.getColumns().clear();
        tvCourseCart.getColumns().addAll(colCourseNameCart, colCourseTypeCart, colCoursePriceCart);
    }

    public void InsertDocument(Document doc) {
        collection = database.getCollection("course");
        collection.insertOne(doc);

    }

    public void DeleteDocument(ObjectId id) {
        Document docDelete = new Document("_id", id);
        DeleteResult deleteResult = collection.deleteOne(docDelete);

    }

    public void EditDocument(Document doc) {
        collection = database.getCollection("course");
        collection.updateOne(eq("_id", getId()), doc);
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

    public Course getCourse(String name) {
        collection = database.getCollection("course");
        doc = new Document("name", name);
        type = new TypeToken<Course>() {
        }.getType();
        Document nameDoc = collection.find(doc).first();
        if (null != nameDoc) {
            course = gson.fromJson(nameDoc.toJson(), type);
        }
        return course;
    }

    @FXML
    void AddToCart(ActionEvent event) {
        ShowDataCart();
        setIdCart(null);
    }

    @FXML
    void doAccept(ActionEvent event) {
        if (getIdCart() == null) {
            FxDialog.showError("Lỗi", "Bạn chưa chọn hàng để accept");
        } else {
            FxDialog.showInformation("Thông báo", "Bạn đã thanh toán thành công");
        }
    }

    public void setLabelNull() {
        lblCourseNameCart.setText(null);
        lblCourseTypeCart.setText(null);
        lblCourseDurationCart.setText(null);
        lblCourseContentCart.setText(null);
        lblCourseAuthorCart.setText(null);
        lblCoursePriceCart.setText(null);
    }

    @FXML
    void doCancel(ActionEvent event) {
        if (getIdCart() == null) {
            FxDialog.showError("Lỗi", "Bạn chưa chọn hàng để cancel");

        } else {
            setIdCart(null);
            setLabelNull();
            FxDialog.showWarning("Cảnh báo", "Bạn vừa bỏ thanh toán");
            arrayCourse.clear();
            ShowDataCart();
        }
    }

    @FXML
    void doDeleteCourse(ActionEvent event) {
        if (FxDialog.showConfirm("Thông báo", "Bạn có muốn xóa khóa học '" + tfCourseNameAdmin.getText() + "'?") == "OK") {
            if (getId() == null) {
                FxDialog.showWarning("Cảnh báo", "Bạn chưa chọn khóa học cần xóa");
            }
            DeleteDocument(getId());
            ShowData();
            ShowDataAdmin();
            FilterCourse(tvCourse, tfFindCourse);
            FilterCourse(tvCourseAdmin, tfFindCourseAdmin);
            setId(null);
        } else {
            return;
        }
    }

    @FXML
    void doEditCourse(ActionEvent event) {
        if (getId() == null) {
            FxDialog.showWarning("Cảnh báo", "Bạn chưa chọn khóa học cần sửa");
        } else {
            setTextField(true);
            tfCourseNameAdmin.requestFocus();
            setButton(true);
            check = false;
        }
    }

    public void FilterCourse(TableView tv, TextField tf) {
        ObservableList<Course> obsList = FXCollections.observableArrayList(listCourse);
        FilteredList<Course> filteredData = new FilteredList<>(obsList, p -> true);
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(course -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (course.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (course.getType().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });
        SortedList<Course> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tv.comparatorProperty());
        tv.setItems(sortedData);

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
        setId(null);
    }

    @FXML
    void doSave(ActionEvent event) {

        try {
            String nameAdmin = tfCourseNameAdmin.getText().trim();
            String typeAdmin = tfCourseTypeAdmin.getText().trim();
            String durationAdmin = tfCourseDurationAdmin.getText().trim();
            String contentAdmin = tfCourseContentAdmin.getText().trim();
            String authorAdmin = tfCourseAuthorAdmin.getText().trim();
            String priceAdmin = tfCoursePriceAdmin.getText().trim();
            Document docInsert = new Document();
            Document docSetTextEdit = new Document();
            if (!nameAdmin.isEmpty() || !typeAdmin.isEmpty() || !durationAdmin.isEmpty()
                    || !contentAdmin.isEmpty() || !authorAdmin.isEmpty() || !priceAdmin.isEmpty()) {
                docInsert = new Document("name", nameAdmin)
                        .append("type", typeAdmin)
                        .append("duration", durationAdmin)
                        .append("content", contentAdmin)
                        .append("author", authorAdmin)
                        .append("price", priceAdmin);
                docSetTextEdit = new Document("$set", new Document("name", nameAdmin)
                        .append("type", typeAdmin)
                        .append("duration", durationAdmin)
                        .append("content", contentAdmin)
                        .append("author", authorAdmin)
                        .append("price", priceAdmin));
            }
            if (check) {
                InsertDocument(docInsert);
            } else {
                EditDocument(docSetTextEdit);
            }
        } catch (NullPointerException ex) {
            FxDialog.showError("Lỗi", "Thông tin thêm khóa học chưa điền đầy đủ");
            return;
        }
        ShowData();
        ShowDataAdmin();
        FilterCourse(tvCourse, tfFindCourse);
        FilterCourse(tvCourseAdmin, tfFindCourseAdmin);
        setNull();
        setTextField(false);
        setButton(false);
        setId(null);
    }

    @FXML
    void doLogout(ActionEvent event) throws IOException {
        if (FxDialog.showConfirm("Thông báo", "Bạn có muốn thoát?") == "OK") {
            Parent register = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene registerScene = new Scene(register);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), register);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            Stage appStage = (Stage) menuBtn.getScene().getWindow();
            appStage.setTitle("Login");
            appStage.setScene(registerScene);
            appStage.show();
        } else {
            return;
        }
    }

    @FXML
    void doAbout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(EducationDocumentController.class.getResource("About.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("About");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
        return;
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
                    lblCoursePrice.setText(String.valueOf(clickedRow.getPrice()));
                    setNameEdit(clickedRow.getName());
                }
            });
            return row;
        });

    }

    public void getRowValueAdmin() {
        tvCourseAdmin.setRowFactory(tv -> {
            TableRow<Course> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {
                    Course clickedRow = row.getItem();
                    tfCourseNameAdmin.setText(clickedRow.getName());
                    tfCourseTypeAdmin.setText(clickedRow.getType());
                    tfCourseDurationAdmin.setText(String.valueOf(clickedRow.getDuration()));
                    tfCourseContentAdmin.setText(clickedRow.getContent());
                    tfCourseAuthorAdmin.setText(clickedRow.getAuthor());
                    tfCoursePriceAdmin.setText(String.valueOf(clickedRow.getPrice()));
                    setId(clickedRow.getId());
                }
            });
            return row;
        });

    }

    public void getRowValueCart() {
        tvCourseCart.setRowFactory(tv -> {
            TableRow<Course> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {
                    Course clickedRow = row.getItem();
                    lblCourseNameCart.setText(clickedRow.getName());
                    lblCourseTypeCart.setText(clickedRow.getType());
                    lblCourseDurationCart.setText(String.valueOf(clickedRow.getDuration()));
                    lblCourseContentCart.setText(clickedRow.getContent());
                    lblCourseAuthorCart.setText(clickedRow.getAuthor());
                    lblCoursePriceCart.setText(String.valueOf(clickedRow.getPrice()));
                    setIdCart(clickedRow.getId());
                }
            });
            return row;
        });

    }

    public void numericOnly() {
        tfCourseDurationAdmin.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfCourseDurationAdmin.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        tfCoursePriceAdmin.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfCoursePriceAdmin.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowData();
        ShowDataAdmin();
        FilterCourse(tvCourse, tfFindCourse);
        FilterCourse(tvCourseAdmin, tfFindCourseAdmin);
        numericOnly();
        setTextField(false);
        setButton(false);
        if (this.usernameProfile == null) {
            this.usernameProfile = "";
        }
        lblUsername.setText("Hello Tu " + this.usernameProfile);
        getRowValue();
        getRowValueAdmin();
        getRowValueCart();
    }
}

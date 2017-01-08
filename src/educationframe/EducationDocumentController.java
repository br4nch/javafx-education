/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educationframe;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dialog.FxDialog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author Le Tam
 */
public class EducationDocumentController implements Initializable {

    
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

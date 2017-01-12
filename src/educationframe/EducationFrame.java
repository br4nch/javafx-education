/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educationframe;

import com.jfoenix.controls.JFXTextField;
import dialog.FxDialog;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
/**
 *
 * @author Le Tam
 */
public class EducationFrame extends Application {

    private JFXTextField tfUsername;

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(1500),root);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.getIcons().add(new Image("http://mikecann.co.uk/wp-content/uploads/2009/12/javafx_logo_color_1.jpg"));
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    private Button loginButton;

    @FXML
    void initialize() {
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Main.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'Main.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'Main.fxml'.";


        loginButton.setOnMouseClicked((event) -> {
            String usernameField = username.getText().trim();
            String passwordField = password.getText().trim();
            DBHandler dbHandler = new DBHandler();
            try {
                dbHandler.getDbConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(usernameField.equals("root")){
                closeWindow(loginButton);

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../views/AdminPage.fxml"));

                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Admin Page");
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.log(Level.SEVERE, "Failed to create new Window.", e);
                }
            }else if(usernameField.equals("student")){
                closeWindow(loginButton);

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../views/StudentPage.fxml"));

                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Student Page");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.log(Level.SEVERE, "Failed to create new Window.", e);
                }
            }
        });


    }



    public void closeWindow(Button btn){
        btn.getScene().getWindow().hide();
    }

}


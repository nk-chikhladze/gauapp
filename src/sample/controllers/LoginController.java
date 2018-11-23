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
    private static String user,pass;
    private boolean check = false;
    private int permission;

    private ResultSet res;

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


        loginButton.setOnMouseClicked((event) -> {

            this.user = username.getText().trim();
            this.pass = password.getText().trim();

            DBHandler dbHandler = new DBHandler();
            try {
                dbHandler.getDbConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            User checkUser = new User(user, pass);

            res = dbHandler.getLogin(checkUser);
            try {
                while (res.next()) {
                    if(res.getString("username").equals(user) && res.getString("password").equals(pass)){
                        check = true;
                        permission = res.getInt("permission");
                        break;
                    }
                }
            }catch(Exception ex){ex.printStackTrace();}

            if(check){
                switch(permission){
                    case 1:
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
                        break;
                    case 0:
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
                        break;
                }
            }else
                System.out.println("Wrong data!");

//            if(this.user.equals("root")){
//                closeWindow(loginButton);
//
//                try {
//                    FXMLLoader fxmlLoader = new FXMLLoader();
//                    fxmlLoader.setLocation(getClass().getResource("../views/AdminPage.fxml"));
//
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = new Stage();
//                    stage.setTitle("Admin Page");
//                    stage.setScene(scene);
//                    stage.show();
//
//                } catch (IOException e) {
//                    Logger logger = Logger.getLogger(getClass().getName());
//                    logger.log(Level.SEVERE, "Failed to create new Window.", e);
//                }
//            }else if(this.user.equals("student")){
//                closeWindow(loginButton);
//
//                try {
//                    FXMLLoader fxmlLoader = new FXMLLoader();
//                    fxmlLoader.setLocation(getClass().getResource("../views/StudentPage.fxml"));
//
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = new Stage();
//                    stage.setTitle("Student Page");
//                    stage.setScene(scene);
//                    stage.show();
//                } catch (IOException e) {
//                    Logger logger = Logger.getLogger(getClass().getName());
//                    logger.log(Level.SEVERE, "Failed to create new Window.", e);
//                }
//            }
        });


    }

    public String[] getLoginInfo(){
        String[] returnArr = new String[]{this.user,this.pass};
        return returnArr;
    }

    public void closeWindow(Button btn){
        btn.getScene().getWindow().hide();
    }

}


package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminController implements Initializable{
    @FXML    Button btn1;
    @FXML    Button btn2;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
    @FXML
    public void buttons(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/Students.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stages = new Stage();
        stages.setScene(new Scene(root1));
        stages.show();
    }
    @FXML
    public void buttons1(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../views/AddStudents.fxml"));
        Parent root2 = (Parent) fxmlLoader1.load();
        Stage stages1 = new Stage();
        stages1.setScene(new Scene(root2));
        stages1.show();
    }
}

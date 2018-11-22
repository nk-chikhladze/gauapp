package sample.controllers;

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

public class StudentPageController implements Initializable{

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    @FXML    private Button point;
    @FXML    private Button table;
    @FXML    private Button attendance;
    @FXML    private Button massenger;
    @FXML
    void buttons(ActionEvent event) {

    }

    @FXML
    void massenger(ActionEvent event) {
    	try {
			Stage newStages = new Stage();
			Parent root1 = FXMLLoader.load(getClass().getResource("../views/Massenger.fxml"));
			Scene scene1 = new Scene(root1);
			newStages.setScene(scene1);
			newStages.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

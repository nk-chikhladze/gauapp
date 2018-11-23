package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddStudentsController implements Initializable{
    private String username,password;

    @FXML
    private TextField regUsername;

    @FXML
    private TextField regPass;

    @FXML    private TextField gender;
    @FXML    private DatePicker bday;
    @FXML    private ComboBox<String> comb1;
    @FXML    private ComboBox<String> comb2;

    @FXML
    private Button regButton;

    ObservableList<String> facultylist = FXCollections.observableArrayList("Informatics", "Business", "Psychology", "Diplomacy");
    ObservableList<String> courselist = FXCollections.observableArrayList("1", "2", "3", "4");
    @Override

    public void initialize(URL location, ResourceBundle resources) {
        comb1.setItems(facultylist);
        comb2.setItems(courselist);



        regButton.setOnAction(event -> {
            username = regUsername.getText().trim();
            password = regPass.getText().trim();

            if(username != null && password != null){
                DBHandler dbHandler = new DBHandler();
                dbHandler.registerUser(new User(username,password));
            }
            closeWindow(regButton);
        });



    }
    public void closeWindow(Button btn){
        btn.getScene().getWindow().hide();
    }
}


package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddStudentsController implements Initializable{

    @FXML    private TextField name;
    @FXML    private TextField lastname;
    @FXML    private TextField gender;
    @FXML    private DatePicker bday;
    @FXML    private ComboBox<String> comb1;
    @FXML    private ComboBox<String> comb2;

    ObservableList<String> facultylist = FXCollections.observableArrayList("Informatika", "Biznesi", "Filologia", "Diplomatia");
    ObservableList<String> courselist = FXCollections.observableArrayList("1", "2", "3", "4");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comb1.setItems(facultylist);
        comb2.setItems(courselist);
    }
}


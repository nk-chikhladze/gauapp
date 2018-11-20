//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class StudentsController implements Initializable {
    @FXML
    public ComboBox<String> combo1;
    @FXML
    public ComboBox<String> combo2;
    ObservableList<String> facultylist = FXCollections.observableArrayList(new String[]{"Informatika", "Biznesi", "Filologia", "Diplomatia"});
    ObservableList<String> courselist = FXCollections.observableArrayList(new String[]{"1", "2", "3", "4"});

    public StudentsController() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.combo1.setItems(this.facultylist);
        this.combo2.setItems(this.courselist);
    }
}

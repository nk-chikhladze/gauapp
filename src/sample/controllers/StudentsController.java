//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentsController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> selFaculty;

    @FXML
    private ComboBox<String> selCourse;

    @FXML
    private Button selBtn;

    ObservableList<String> facultylist = FXCollections.observableArrayList(new String[]{"Informatika", "Biznesi", "Filologia", "Diplomatia"});
    ObservableList<String> courselist = FXCollections.observableArrayList(new String[]{"1", "2", "3", "4"});

    public StudentsController() {
    }

    public void initialize(URL location, ResourceBundle resources) {


        this.selFaculty.setItems(this.facultylist);
        this.selCourse.setItems(this.courselist);

        selBtn.setOnMouseClicked((event) -> {
            LoginController lc = new LoginController();
            String[] loginInfo = lc.getLoginInfo();



            User getInfo = new User(loginInfo[0], loginInfo[1]);
            DBHandler dbHandler = new DBHandler();
            ResultSet resSet = dbHandler.getFullUser(getInfo);


//            AdminController ac = new AdminController(resSet);
//            ac.fillTable();


            lc.closeWindow(selBtn);
            //Data is brought, need to show it somewhere



        });
    }
}



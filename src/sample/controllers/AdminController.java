package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

<<<<<<< HEAD
import javafx.collections.FXCollections;
=======
>>>>>>> 0c43b9c3665284eb98f4c5f2e34df155d3d6e4f9
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController extends LoginController implements Initializable{
    private ResultSet res;
    private ObservableList<User> list;

    private String[] loginInfo;

    public AdminController(){
        this.loginInfo = super.getLoginInfo();

    }

    @FXML    Button btn1;
    @FXML    Button btn2;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TableView<User> tableVIew;

    @FXML
    public TableColumn<User, Integer> colId;

    @FXML
    public TableColumn<User, String> colUser;

    @FXML
<<<<<<< HEAD
    public TableColumn<User, String> colPass;
=======
    public TableColumn<?, ?> colId;
>>>>>>> 0c43b9c3665284eb98f4c5f2e34df155d3d6e4f9

    @FXML
    public TableColumn<User, Integer> colPerm;

    @FXML
    private ComboBox<String> courseCB;

    @FXML
    private ComboBox<String> facultyCB;

    //combobox information
    ObservableList<String> facultylist = FXCollections.observableArrayList(new String[]{"Informatics", "Business", "Psychology", "Diplomacy"});
    ObservableList<String> courselist = FXCollections.observableArrayList(new String[]{"1", "2", "3", "4"});


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        this.courseCB.setItems(this.courselist);
        this.facultyCB.setItems(this.facultylist);

        colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colUser.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        colPass.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        colPerm.setCellValueFactory(new PropertyValueFactory<User, Integer>("permission"));

        btn1.setOnAction(event -> {
            String course, faculty;

            course = courseCB.getValue();
            faculty = facultyCB.getValue();

            if(course == null || faculty == null){
                System.out.println("Choose course & faculty first.");
            }else{
                //clear table before it gets data
                tableVIew.getItems().clear();

                User getInfo = new User(loginInfo[0], loginInfo[1]);
                DBHandler dbHandler = new DBHandler();
                res = dbHandler.getFullUser(getInfo);
                try {
                    while (res.next()) {

<<<<<<< HEAD
                        User newUser = new User();
                        newUser.setId(this.res.getInt("Id"));
                        newUser.setUsername(this.res.getString("Username"));
                        newUser.setPassword(this.res.getString("Password"));
                        newUser.setPermission(this.res.getInt("Permission"));

                        newUser.fillTestData();
=======
        try {
//            System.out.println(this.res.next())
//            check();
            int count = 0;
            while(this.res.next()){
                //aq unda moxdes tableshi informaciis chawera
                System.out.println("ID: " + this.res.getInt("id") + " Username: " + this.res.getString("username") + " Password: " + this.res.getString("password") + " Permission: " + this.res.getInt("permission"));

                User newUser = new User();
                newUser.setId(this.res.getInt("id"));
                newUser.setUsername(this.res.getString("username"));
                newUser.setPassword(this.res.getString("password"));
                newUser.setPermission(this.res.getInt("permission"));


//                TableView<String> table = new TableView<>();

//                TableColumn userIdCol = new TableColumn("ID");
//                TableColumn<User, String> userUsernameCol = new TableColumn<User, String>("Username");
//                TableColumn<User, String> userPasswordCol = new TableColumn<User, String>("Password");
//                TableColumn<User, Integer> userPermissionCol = new TableColumn<User, Integer>("Permission");

//                userIdCol.setCellValueFactory(new PropertyValueFactory<>("IDasd"));
//                userIdCol.setText("asd");
//                tableVIew.setEditable(true);
//                ObservableList<String> list = newUser.getList();
//                tableVIew.getColumns().addAll(userIdCol);
//                tableVIew.refresh();
//                tableVIew.setItems(list);
//                table.setItems(list);
//                colId.setText("asd");

//                table.refresh();



//                table.getColumns().addAll(userIdCol, userUsernameCol, userPasswordCol, userPermissionCol);

>>>>>>> 0c43b9c3665284eb98f4c5f2e34df155d3d6e4f9

                        list = newUser.getList();

                    }
                }catch(Exception ex){ ex.printStackTrace(); }

                tableVIew.setItems(list);
                tableVIew.refresh();

            }


        });








    }
    @FXML
    public void buttons(ActionEvent event) throws IOException{
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/Students.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stages = new Stage();
//        stages.setScene(new Scene(root1));
//        stages.show();
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

package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController implements Initializable{
    private ResultSet res;

    public AdminController(){}
    public AdminController(ResultSet result){
        this.res = result;
    }

    @FXML    Button btn1;
    @FXML    Button btn2;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TableView<?> tableVIew;

    @FXML
    public TableColumn<?, ?> colId;

    @FXML
    public TableColumn<?, ?> colUser;

    @FXML
    public TableColumn<?, ?> colPass;

    @FXML
    private TableColumn<?, ?> colPerm;


    public void check(){
        try{
            if(this.res.next()){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void fillTable(){

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





            }
        }catch(Exception ex){
            System.out.println(ex);
        }
//        try {
//            int count = 0;
//            rs.first();
//            while (rs.next()) {
//                colId.setText(Integer.toString(rs.getInt("id")));
//                System.out.println(count++);
//            }
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        assert tableVIew != null : "fx:id=\"tableVIew\" was not injected: check your FXML file 'AdminPage.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'AdminPage.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'AdminPage.fxml'.";
        assert colUser != null : "fx:id=\"colUser\" was not injected: check your FXML file 'AdminPage.fxml'.";
        assert colPass != null : "fx:id=\"colPass\" was not injected: check your FXML file 'AdminPage.fxml'.";
        assert colPerm != null : "fx:id=\"colPerm\" was not injected: check your FXML file 'AdminPage.fxml'.";




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

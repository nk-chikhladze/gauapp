package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class MassengerController implements Initializable{
	
    @FXML    public ComboBox<String> combo1;
    
    ObservableList<String> list = FXCollections.observableArrayList("Online", "Ofline");
	@Override
	public void initialize(URL location,ResourceBundle resources) {
		combo1.setItems(list);		
	}
	
}

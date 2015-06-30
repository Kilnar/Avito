package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class MainController {

    @FXML
    private ListView<String> listView;
    private ObservableList observableList;
    private ArrayList<String> stringArrayList;

    public MainController(){
        observableList = FXCollections.observableArrayList();
        stringArrayList = new ArrayList<String>();
    }
    @FXML
    private void initialize() {
        setListView();
    }
    public void setListView(){
        stringArrayList.add("String 1");
        stringArrayList.add("String 2");
        stringArrayList.add("String 3");
        observableList.setAll(stringArrayList);
        listView.setItems(observableList);
        listView.setCellFactory(param -> new ListViewCell());
    }

}

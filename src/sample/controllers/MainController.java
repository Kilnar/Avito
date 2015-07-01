package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sample.api.AvitoAd;
import sample.api.AvitoApi;

import java.io.IOException;
import java.util.List;

public class MainController {

    @FXML
    private ListView<AvitoAd> listView;
    private ObservableList observableList;
    private List<AvitoAd> stringArrayList;

    public MainController(){
        observableList = FXCollections.observableArrayList();
    }
    @FXML
    private void initialize() {
        setListView();
    }
    public void setListView(){

        AvitoApi avitoApi = new AvitoApi();
        try {
            observableList.setAll(avitoApi.getAdsFromRawQuery("https://www.avito.ru/ulyanovsk/avtomobili/vaz_lada?i=1&pmax=3000000&pmin=90000"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        listView.setItems(observableList);
        listView.setCellFactory(new Callback<ListView<AvitoAd>, ListCell<AvitoAd>>() {
            @Override
            public ListCell<AvitoAd> call(ListView<AvitoAd> param) {
                return new ListViewCell();
            }
        });
    }

}

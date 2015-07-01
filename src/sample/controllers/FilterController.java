package sample.controllers;

/**
 * Created by strat on 30.06.15.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import sample.custom.NumberTextField;

import java.io.IOException;

public class FilterController {

    public ChoiceBox subcategory;
    public ChoiceBox category;
    public ChoiceBox citiescategory;
    public CheckBox photocheck;
    public NumberTextField finishPrice;
    public NumberTextField startPrice;

    private void initialize() {
    }

    public void actionSearch(ActionEvent actionEvent) {
        MainController.httpQuery = "";
        openMainWindow();
    }

    private void openMainWindow() {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("/sample/view/main.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Main");
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

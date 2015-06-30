package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by strat on 30.06.15.
 */
public class CardController{
    @FXML
    public AnchorPane itemPane;
    @FXML
    public Label itemName;

    public CardController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/card.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setInfo(String string)
    {
        itemName.setText(string);
    }

    public AnchorPane getItem()
    {
        return itemPane;
    }

}

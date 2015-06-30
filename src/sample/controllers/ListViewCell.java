package sample.controllers;

import javafx.scene.control.ListCell;

/**
 * Created by strat on 30.06.15.
 */
public class ListViewCell extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null){
            CardController cardController = new CardController();
            cardController.setInfo(item);
            setGraphic(cardController.getItem());
        }
    }
}

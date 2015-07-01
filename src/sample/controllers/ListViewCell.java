package sample.controllers;

import javafx.scene.control.ListCell;
import sample.api.AvitoAd;

/**
 * Created by strat on 30.06.15.
 */
public class ListViewCell extends ListCell<AvitoAd> {
    @Override
    protected void updateItem(AvitoAd item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null){
            CardController cardController = new CardController();
//            Image img = new Image("http://best-iconki.ru/downloads/PNG/256/programms-0002-1.png");
            System.out.println(item.getPhoto().toString());
           // cardController.setInfo(item.getName(), item.getDescription(), item.getPrice(),img);
            setGraphic(cardController.getItem());
        }
    }
}

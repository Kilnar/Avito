package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sun.rmi.runtime.Log;

import javax.lang.model.element.Element;
import java.io.IOException;

public class Main extends Application {

    private static String URL = "https://www.avito.ru/map";
    private static String mainUrl = "http://www.avito.ru";
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        parseCategories();
        launch(args);
    }

    private static void parseCategories () {
        try {
            Document doc  = Jsoup.connect(URL).get();
            Elements categories = doc.select("dl");
            for (org.jsoup.nodes.Element categor : categories) {
                org.jsoup.nodes.Element title = categor.select("dt").first();
                Elements _categories = categor.select("dd");
                System.out.println(mainUrl+title.select("a").first().attr("href")); // address main categories
                System.out.println("main" +"\t" + title.select("a").first().html()); // Name main categories

                for (org.jsoup.nodes.Element element : _categories) {
                        org.jsoup.nodes.Element links = element.select("a").first();
                        String linkHref = links.attr("href");
                        System.out.println("\t\t"+mainUrl+linkHref); // address
                        String linkInnerH = links.html();
                        System.out.println("\t\t\t"+linkInnerH); // Name other categorie
                    }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

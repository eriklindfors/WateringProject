package summerProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

    static final double WIDTH = 1280;
    static final double HEIGHT = 720;

    TopMenu topmenuBar = new TopMenu();
    LeftMenu leftMenuBar = new LeftMenu();
    InformationField informationField = new InformationField();

    @Override
    public void start(Stage stage) throws Exception{
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.web("#CFF5C5"));
        stage.setScene(scene);

        root.setTop(topmenuBar);
        root.setLeft(leftMenuBar);
        root.setCenter(informationField);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

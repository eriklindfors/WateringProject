package summerProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

    static final double WIDTH = 1280;
    static final double HEIGHT = 720;

    private TopMenu topmenuBar = new TopMenu();
    private LeftMenu leftMenuBar = new LeftMenu();
    private InformationField informationField = new InformationField();

    private ImageView background = new ImageView(new Image("greenBackground.jpg"));


    @Override
    public void start(Stage stage) throws Exception{
        Pane root = new Pane();
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefWidth(WIDTH);
        borderPane.setPrefHeight(HEIGHT);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.web("#CFF5C5"));
        stage.setScene(scene);

        borderPane.setTop(topmenuBar);
        borderPane.setLeft(leftMenuBar);
        borderPane.setCenter(informationField);

        root.getChildren().addAll(background, borderPane);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

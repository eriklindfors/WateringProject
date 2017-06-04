package summerProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

    static final double WIDTH = 1000;
    static final double HEIGHT = 600;

    private LeftMenu leftMenuBar = new LeftMenu();
    private StatisticsNode statisticsNode = new StatisticsNode();

    private ImageView background = new ImageView(new Image("greenBackground.jpg"));


    @Override
    public void start(Stage stage) throws Exception{
        Pane root = new Pane();
        Pane center = new Pane();
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefWidth(WIDTH);
        borderPane.setPrefHeight(HEIGHT);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.web("#CFF5C5"));
        stage.setScene(scene);

        center.getChildren().add(statisticsNode);
        borderPane.setLeft(leftMenuBar);
        borderPane.setCenter(center);

        root.getChildren().addAll(background, borderPane);

        statisticsNode.setGaugeMeter(70);




        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

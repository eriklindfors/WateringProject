package summerProject;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{

    static final double WIDTH = 1000;
    static final double HEIGHT = 600;

    private Point2D mouseLocation = new Point2D(0, 0);

    private LeftMenu leftMenu = new LeftMenu();
    private StatisticsNode statisticsNode = new StatisticsNode();
    private ImageView background = new ImageView(new Image("flowerBackground.jpg"));



    @Override
    public void start(Stage stage) throws Exception{
        Pane root = new Pane();
        Pane center = new Pane();
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefWidth(WIDTH);
        borderPane.setPrefHeight(HEIGHT);
        Scene scene = new Scene(root, WIDTH, HEIGHT);;
        stage.setScene(scene);

        borderPane.setCenter(center);
        borderPane.setLeft(leftMenu);


        root.getChildren().addAll(background, borderPane);

        //Background
        background.setFitWidth(WIDTH);
        background.setFitHeight(HEIGHT);

        leftMenu.getFirstButton().setOnMouseClicked(e -> {
            FadeTransition ft = new FadeTransition(new Duration(500), statisticsNode);
            if(center.getChildren().contains(statisticsNode)){
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ft.setOnFinished(eh ->{
                    center.getChildren().remove(statisticsNode);
                });
            }
            else{
                center.getChildren().add(statisticsNode);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

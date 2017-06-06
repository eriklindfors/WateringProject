package summerProject;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{

    static final double WIDTH = 1000;
    static final double HEIGHT = 600;

    private LeftMenu leftMenu = new LeftMenu();
    private HumidityWindow humidityWindow = new HumidityWindow(WIDTH / 2, HEIGHT / 2);
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

        //Button 1
        leftMenu.getFirstButton().setOnMouseClicked(e -> {
            FadeTransition ft = new FadeTransition(new Duration(500), humidityWindow);
            if(center.getChildren().contains(humidityWindow)){
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ft.setOnFinished(eh ->{
                    center.getChildren().remove(humidityWindow);
                });
            }
            else{
                center.getChildren().add(humidityWindow);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
            }
        });

        //Test if key pressed can move gauge arrow
        scene.setOnKeyPressed(e -> {
            RotateTransition rt = new RotateTransition(new Duration(1000), humidityWindow.getGaugeMeter().getArrow());
            if(center.getChildren().contains(humidityWindow)){
                if(e.getCode() == KeyCode.A){
                    rt.setByAngle(10);
                    rt.play();
                }
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

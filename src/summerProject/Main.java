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

    static final double WIDTH = 1280;
    static final double HEIGHT = 800;

    private ImageView background = new ImageView(new Image("flowerBackground.jpg"));

    private LeftMenu leftMenu = new LeftMenu();
    private HumidityWindow humidityWindow = new HumidityWindow(WIDTH / 2, HEIGHT / 2);
    private StatisticsWindow statisticsWindow = new StatisticsWindow(WIDTH / 2, HEIGHT / 2);

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

        //Connect left menu buttons to chosen window nodes and add animation
        setWindowAnimationOnMenuButtonPressed(center, leftMenu.getFirstButton(), humidityWindow);
        setWindowAnimationOnMenuButtonPressed(center, leftMenu.getSecondButton(), statisticsWindow);

        //Test if key pressed can move gauge arrow
        scene.setOnKeyPressed(e -> {
            if(center.getChildren().contains(humidityWindow)){
                RotateTransition rt = new RotateTransition(new Duration(1000), humidityWindow.getGaugeMeter().getArrow());
                if(e.getCode() == KeyCode.A){
                    rt.setByAngle(10);
                    rt.play();
                }
            }
        });

        stage.setTitle("My Plants");
        stage.show();
    }

    private void setWindowAnimationOnMenuButtonPressed(Pane center, LeftMenu.MenuButton button, BaseWindow baseWindow){
        button.setOnMouseClicked(e -> {
            FadeTransition ft = new FadeTransition(new Duration(500), baseWindow);
            if(center.getChildren().contains(baseWindow)){
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ft.setOnFinished(eh ->{
                    center.getChildren().remove(baseWindow);
                });
            }
            else{
                center.getChildren().add(baseWindow);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

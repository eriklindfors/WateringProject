package summerProject;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class LeftMenu extends StackPane {

    private VBox vbox = new VBox();

    private Rectangle background = new Rectangle((int)(MenuButton.BUTTON_RADIUS * 2 + MenuButton.BUTTON_RADIUS * 0.2),
            Main.HEIGHT);
    private MenuButton button1 = new MenuButton("Statistics");
    private MenuButton button2 = new MenuButton("Other");

    public LeftMenu(){
        vbox.getChildren().addAll(button1, button2);
        this.getChildren().addAll(background, vbox);
        this.setTranslateX(-MenuButton.BUTTON_RADIUS);
        vbox.setSpacing(5);
        background.setStroke(Color.DARKGRAY);
        background.setOpacity(0.1);

        TranslateTransition tt = new TranslateTransition(Duration.millis(3000), this);
        tt.setToX(0);
        tt.play();
    }



    private class MenuButton extends StackPane{

        private static final double BUTTON_RADIUS = Main.WIDTH * 0.05;

        private Circle background = new Circle(BUTTON_RADIUS);
        private Label text;

        private MenuButton(String buttonText){
            text = new Label(buttonText);
            text.setFont(Font.font(null, FontWeight.BOLD, 20));
            text.setTextFill(Color.WHITE);
            background.setFill(Color.web("#B3D8A5"));
            background.setOpacity(0.3);

            this.setOnMousePressed(e -> {
                background.setFill(Color.web("#97C28A"));
            });
            this.setOnMouseReleased(e -> {
                background.setFill(Color.web("#B3D8A5"));
            });

            this.getChildren().addAll(background, text);
        }
    }
}



package summerProject;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
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

    //private Rectangle background = new Rectangle((int)(MenuButton.BUTTON_RADIUS * 2 + MenuButton.BUTTON_RADIUS * 0.2),
    //        Main.HEIGHT);
    private MenuButton button1 = new MenuButton("Humidity");
    //private MenuButton button2 = new MenuButton("Other");

    public LeftMenu(){
        vbox.getChildren().addAll(button1);
        this.getChildren().addAll(vbox);
        this.setTranslateY(Main.HEIGHT);
        vbox.setSpacing(5);
        this.setTranslateX(15);
        //background.setStroke(Color.DARKGRAY);
        //background.setOpacity(0.1);
        TranslateTransition tt = new TranslateTransition(new Duration(2000), this);

        tt.setToY(15);
        tt.play();
    }

    public MenuButton getFirstButton(){
        return button1;
    }


    public class MenuButton extends StackPane{

        private static final double BUTTON_RADIUS = Main.WIDTH * 0.05;

        private Circle background = new Circle(BUTTON_RADIUS);
        private Label text;

        private MenuButton(String buttonText){
            text = new Label(buttonText);
            text.setFont(Font.font(null, FontWeight.BOLD, 20));
            text.setTextFill(Color.WHITE);
            background.setFill(Color.DARKGRAY);
            background.setOpacity(0.6);

            this.setOnMousePressed(e -> {
                background.setFill(Color.GRAY);
            });
            this.setOnMouseReleased(e -> {
                background.setFill(Color.DARKGRAY);
            });

            this.getChildren().addAll(background, text);
        }
    }
}



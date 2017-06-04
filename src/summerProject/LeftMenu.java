package summerProject;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LeftMenu extends VBox{

    private MenuButton button1 = new MenuButton("Statistics");
    private MenuButton button2 = new MenuButton("Other");

    public LeftMenu(){
        this.getChildren().addAll(button1, button2);
    }

    private class MenuButton extends StackPane{

        private static final double BUTTON_WIDTH = 300;
        private static final double BUTTON_HEIGHT = 100;

        private Rectangle background = new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT);
        private Label text;

        private MenuButton(String buttonText){
            text = new Label(buttonText);
            background.setFill(Color.web("#B3D8A5"));

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



package summerProject;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BaseWindow extends StackPane {

    private Rectangle outerBackground;
    private Rectangle innerBackground ;

    private double mouseX ;
    private double mouseY ;

    public BaseWindow(double width, double height){
        outerBackground = new Rectangle(width, height);
        innerBackground = new Rectangle(width - 10, height - 10);

        this.getChildren().addAll(outerBackground, innerBackground);

        outerBackground.setFill(Color.BLACK);
        innerBackground.setFill(Color.GRAY);

        outerBackground.setArcWidth(15);
        outerBackground.setArcHeight(15);
        innerBackground.setArcWidth(15);
        innerBackground.setArcHeight(15);

        outerBackground.setOpacity(0.7);
        innerBackground.setOpacity(0.2);

        setOnMousePressed(event -> {
            this.toFront();
            mouseX = event.getSceneX() ;
            mouseY = event.getSceneY() ;
        });

        setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mouseX ;
            double deltaY = event.getSceneY() - mouseY ;
            relocate(getLayoutX() + deltaX, getLayoutY() + deltaY);
            mouseX = event.getSceneX() ;
            mouseY = event.getSceneY() ;
        });
    }
}

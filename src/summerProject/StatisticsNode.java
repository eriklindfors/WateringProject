package summerProject;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;

public class StatisticsNode extends StackPane {

    private Rectangle outerBackground = new Rectangle(Main.WIDTH * 0.4, Main.HEIGHT * 0.4);
    private Rectangle innerBackground = new Rectangle(outerBackground.getWidth() - 10,
            outerBackground.getHeight() - 10);
    private GaugeMeter gaugeMeter = new GaugeMeter(innerBackground.getWidth() / 2);

    private double mouseX ;
    private double mouseY ;

    public StatisticsNode(){

        this.getChildren().addAll(outerBackground, innerBackground, gaugeMeter);

        outerBackground.setFill(Color.BLACK);
        innerBackground.setFill(Color.GRAY);

        outerBackground.setArcWidth(15);
        outerBackground.setArcHeight(15);
        innerBackground.setArcWidth(15);
        innerBackground.setArcHeight(15);

        outerBackground.setOpacity(0.7);
        innerBackground.setOpacity(0.2);

        gaugeMeter.setTranslateX(50);

        this.setTranslateX(Main.WIDTH * 0.10);
        this.setTranslateY(Main.HEIGHT * 0.10);

        //this.setEffect(new DropShadow(2, 5, 5, Color.BLACK));

        setOnMousePressed(event -> {
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

    public void setGaugeMeter(double change){
        gaugeMeter.set(change);
    }
}

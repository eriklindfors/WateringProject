package summerProject;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class GaugeMeter extends StackPane {

    private static final double SIZE_MODIFIER = 0.5;
    private final Color ARC_STROKE_COLOR = Color.WHITE;
    private final double ARC_STROKE_WIDTH = 4;

    private Group layout = new Group();

    ImageView arrow = new ImageView(new Image("gaugeArrow.png"));

    private Arc a1;
    private Arc a2;
    private Arc a3;
    private Arc a4;
    private Arc a5;
    private Arc a6;
    private Arc middle;

    public GaugeMeter(double windowWidth){
        a1 = new Arc(0, 0, windowWidth * SIZE_MODIFIER,
                windowWidth * SIZE_MODIFIER, 0, 30);
        a2 = new Arc(0, 0, windowWidth * SIZE_MODIFIER,
                windowWidth * SIZE_MODIFIER, 30, 30);
        a3 = new Arc(0, 0, windowWidth * SIZE_MODIFIER,
                windowWidth * SIZE_MODIFIER, 60, 30);
        a4 = new Arc(0, 0, windowWidth * SIZE_MODIFIER,
                windowWidth * SIZE_MODIFIER, 90, 30);
        a5 = new Arc(0, 0, windowWidth * SIZE_MODIFIER,
                windowWidth * SIZE_MODIFIER, 120, 30);
        a6 = new Arc(0, 0, windowWidth * SIZE_MODIFIER,
                windowWidth * SIZE_MODIFIER, 150, 30);
        middle = new Arc(0, 0, windowWidth * SIZE_MODIFIER * 0.7,
                windowWidth * SIZE_MODIFIER * 0.7, 0, 180);

        arrow.setFitWidth(windowWidth * 0.6);
        arrow.setFitHeight(windowWidth * SIZE_MODIFIER * 0.4);
        arrow.setTranslateY(windowWidth * SIZE_MODIFIER * 0.35);

        a1.setFill(Color.GREEN);
        a2.setFill(Color.GREENYELLOW);
        a3.setFill(Color.YELLOW);
        a4.setFill(Color.ORANGE);
        a5.setFill(Color.RED);
        a6.setFill(Color.DARKRED);
        a1.setStroke(ARC_STROKE_COLOR);
        a2.setStroke(ARC_STROKE_COLOR);
        a3.setStroke(ARC_STROKE_COLOR);
        a4.setStroke(ARC_STROKE_COLOR);
        a5.setStroke(ARC_STROKE_COLOR);
        a6.setStroke(ARC_STROKE_COLOR);
        a1.setStrokeWidth(ARC_STROKE_WIDTH);
        a2.setStrokeWidth(ARC_STROKE_WIDTH);
        a3.setStrokeWidth(ARC_STROKE_WIDTH);
        a4.setStrokeWidth(ARC_STROKE_WIDTH);
        a5.setStrokeWidth(ARC_STROKE_WIDTH);
        a6.setStrokeWidth(ARC_STROKE_WIDTH);
        a1.setType(ArcType.ROUND);
        a2.setType(ArcType.ROUND);
        a3.setType(ArcType.ROUND);
        a4.setType(ArcType.ROUND);
        a5.setType(ArcType.ROUND);
        a6.setType(ArcType.ROUND);

        middle.setFill(Color.WHITE);
        middle.setStroke(Color.WHITE);
        layout.getChildren().addAll(a1, a2, a3, a4, a5, a6, middle);
        this.getChildren().addAll(layout, arrow);
    }

    public void set(double value){
        arrow.setRotate(-value);
    }

    public ImageView getArrow(){
        return arrow;
    }
}

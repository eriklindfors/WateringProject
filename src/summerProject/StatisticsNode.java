package summerProject;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StatisticsNode extends StackPane {

    private Rectangle outerBackground = new Rectangle(Main.WIDTH * 0.4, Main.HEIGHT * 0.4);
    private Rectangle innerBackground = new Rectangle(outerBackground.getWidth() - 10,
            outerBackground.getHeight() - 10);
    private GaugeMeter gaugeMeter = new GaugeMeter(innerBackground.getWidth() / 1.5);
    private Label gaugeMeterName = new Label("Humidity");
    private Label dry = new Label("Dry");
    private Label humid = new Label("Hum");


    private double mouseX ;
    private double mouseY ;

    public StatisticsNode(){

        this.getChildren().addAll(outerBackground, innerBackground, gaugeMeter, gaugeMeterName, dry, humid);

        outerBackground.setFill(Color.BLACK);
        innerBackground.setFill(Color.GRAY);

        outerBackground.setArcWidth(15);
        outerBackground.setArcHeight(15);
        innerBackground.setArcWidth(15);
        innerBackground.setArcHeight(15);

        outerBackground.setOpacity(0.7);
        innerBackground.setOpacity(0.2);

        gaugeMeter.setTranslateY(20);
        gaugeMeter.set(-180);

        gaugeMeterName.setFont(Font.font(null, FontWeight.EXTRA_BOLD, null, 25));
        gaugeMeterName.setTextFill(Color.WHITE);
        gaugeMeterName.setTranslateY(-75);

        dry.setFont(Font.font(null, FontWeight.BOLD, null, 15));
        dry.setTextFill(Color.WHITE);
        dry.setTranslateY(75);
        dry.setTranslateX(-150);

        humid.setFont(Font.font(null, FontWeight.BOLD, null, 15));
        humid.setTextFill(Color.WHITE);
        humid.setTranslateY(75);
        humid.setTranslateX(155);


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

    public GaugeMeter getGaugeMeter(){
        return gaugeMeter;
    }
}

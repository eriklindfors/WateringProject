package summerProject;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HumidityWindow extends BaseWindow {

    private GaugeMeter gaugeMeter;
    private Label gaugeMeterName = new Label("Humidity");
    private Label dry = new Label("Dry");
    private Label humid = new Label("Hum");

    public HumidityWindow(double width, double height){
        super(width, height);

        gaugeMeter = new GaugeMeter(width / 2);

        this.getChildren().addAll(gaugeMeter, gaugeMeterName, dry, humid);

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

        //this.setEffect(new DropShadow(2, 5, 5, Color.BLACK))
    }

    public GaugeMeter getGaugeMeter(){
        return gaugeMeter;
    }
}

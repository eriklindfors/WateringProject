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

        dry.setFont(Font.font(null, FontWeight.BOLD, null, height / 20));
        dry.setTextFill(Color.WHITE);
        dry.setTranslateY(height / 4);
        dry.setTranslateX(-width / 3.4);

        humid.setFont(Font.font(null, FontWeight.BOLD, null, height / 20));
        humid.setTextFill(Color.WHITE);
        humid.setTranslateY(height / 4);
        humid.setTranslateX(width / 3.3);

        this.setTranslateX(Main.WIDTH * 0.10);
        this.setTranslateY(Main.HEIGHT * 0.10);
    }

    public GaugeMeter getGaugeMeter(){
        return gaugeMeter;
    }
}

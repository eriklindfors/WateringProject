package summerProject;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Cylinder;

public class WaterBarrel extends Group{

    private static final double WATER_MAX_HEIGHT = 431;
    private static final double WATER_MAX_WIDTH = 485;


    Cylinder water = new Cylinder();
    ImageView barrelBackground;
    ImageView barrel;

    public WaterBarrel(){
        water.setHeight(WATER_MAX_HEIGHT / 2);
        water.setRadius(WATER_MAX_WIDTH / 2);
        water.setRotate(200);

        barrelBackground = new ImageView(new Image("fatemehbarrelbackground.png"));
        barrel = new ImageView(new Image("fatemehbarrelfront.png"));

        this.getChildren().addAll(barrelBackground, water, barrel);
    }

    public void setWaterLevel(double percentage){
        water.setScaleY(percentage / 100);
        water.setTranslateY(WATER_MAX_HEIGHT * (percentage / 100));
    }
}
